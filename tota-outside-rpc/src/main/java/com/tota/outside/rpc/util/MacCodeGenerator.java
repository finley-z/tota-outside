package com.tota.outside.rpc.util;

import com.tota.se.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MacCodeGenerator {
    private static String encryptKey;

    /***
     * 计算Mac通讯押码
     * @param keySet
     * @param macData
     * @return
     */
    public static String computeMac(String keySet,String macData) {
        String key = "";      //通过 encryptKey 解密keySet得到的明文秘钥
        String keyA = key.substring(0, 16);
        String keyB = key.substring(16, key.length());

        List<String> macRep = new ArrayList<>();

        int position = 0;
        int length = macData.length();
        while (position < length) {
            int subLen = (length - position) >= 16 ? 16 : (length - position);
            String val = macData.substring(position, position + subLen);
            if (subLen < 16) {
                val = fixZero(val, 16, false);
            }
            position += subLen;
            macRep.add(val);
        }

        String divisor = "0000000000000000";
        String res;
        Iterator<String> it = macRep.iterator();
        while (it.hasNext()) {
            String str = it.next();

            divisor = xor(str, divisor);

            divisor = divisor; //使用 keyA 对divisor进行加密操作

        }

        return null;
    }

    /***
     * 十六进制数值进行异或运算
     * @param strHex_X
     * @param strHex_Y
     * @return
     */
    private static String xor(String strHex_X, String strHex_Y) {
        //将x、y转成二进制形式
        String anotherBinary = new BigInteger(strHex_X, 16).toString(2);
        String thisBinary = new BigInteger(strHex_Y, 16).toString(2);
        String result = "";

        anotherBinary = fixZero(anotherBinary, 64, true);
        thisBinary = fixZero(thisBinary, 64, true);

        //异或运算
        for (int i = 0; i < anotherBinary.length(); i++) {
            result += thisBinary.charAt(i) ^ anotherBinary.charAt(i);
        }

        return new BigInteger(result, 2).toString(16);
    }

    /***
     * 补零
     * @return
     */
    private static String fixZero(String value, int length, boolean isLeft) {
        if (value.length() > length) {
            throw new BusinessException("值的长度超出限制");
        }
        if (value.length() == length) {
            return value;
        }
        String zeros = intArrToString(new int[length - value.length()]);
        if (isLeft) {
            return zeros + value;
        } else {
            return value + zeros;
        }
    }

    private static String intArrToString(int a[]) {
        if (a == null)
            return "";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "";
        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.toString();
        }
    }


    public static void main(String[] args) {
//        BigInteger i= BigInteger.valueOf("AC4A9E0CC9F1BF49",16);
        // BD4A9E0CCCB5BF49
        String res = MacCodeGenerator.xor("1100000005440000", "AC4A9E0CC9F1BF49");
        System.out.println("res:" + res);
    }


    //将配置的key注入到静态属性中
    @Value("${dgt.key}")
    public  void setEncryptKey(String encryptKey) {
        MacCodeGenerator.encryptKey = encryptKey;
    }
}

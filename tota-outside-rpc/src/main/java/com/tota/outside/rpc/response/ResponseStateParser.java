package com.tota.outside.rpc.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ResponseStateParser {
    private static Map<String,String> responseMap=new HashMap<>();

    static{

        //联机报文应答定义
         responseMap.put("00","{'isSuccess':true,desc:'成功'}");
         responseMap.put("01","{'isSuccess':false,desc:'无效的加密压缩算法'}");
         responseMap.put("02","{'isSuccess':false,desc:'无效的消息类型码'}");
         responseMap.put("03","{'isSuccess':false,desc:'无效的消息版本'}");
         responseMap.put("04","{'isSuccess':false,desc:'报文长度无效'}");
         responseMap.put("05","{'isSuccess':false,desc:'通讯 MAC 错'}");
         responseMap.put("06","{'isSuccess':false,desc:'通讯超时'}");
         responseMap.put("07","{'isSuccess':false,desc:'通讯目标节点不可到达'}");
         responseMap.put("08","{'isSuccess':false,desc:'报文格式错误'}");
         responseMap.put("09","{'isSuccess':false,desc:'操作员不存在'}");
         responseMap.put("0A","{'isSuccess':false,desc:'操作员口令错误'}");
         responseMap.put("0B","{'isSuccess':false,desc:'POS 机号不存在'}");
         responseMap.put("0C","{'isSuccess':false,desc:'POS 机已禁用'}");
         responseMap.put("0D","{'isSuccess':false,desc:'SAM 卡号不存在'}");
         responseMap.put("0E","{'isSuccess':false,desc:'SAM 卡号已禁用'}");
         responseMap.put("12","{'isSuccess':false,desc:'操作员无效操作 SAM 卡'}");
         responseMap.put("13","{'isSuccess':false,desc:'SAM 卡与 ED 对应关系错'}");
         responseMap.put("14","{'isSuccess':false,desc:'SAM 卡尚未签退'}");
         responseMap.put("15","{'isSuccess':false,desc:'SAM 卡尚未签到'}");
         responseMap.put("16","{'isSuccess':false,desc:'上一日充值交易未上送完毕'}");
         responseMap.put("17","{'isSuccess':false,desc:'签到应答写入机具失败'}");
         responseMap.put("18","{'isSuccess':false,desc:'签退应答写入机具失败'}");
         responseMap.put("19","{'isSuccess':false,desc:'文件名已存在'}");
         responseMap.put("1A","{'isSuccess':false,desc:'文件打开/读写失败'}");
         responseMap.put("1B","{'isSuccess':false,desc:'文件写入失败'}");
         responseMap.put("1C","{'isSuccess':false,desc:'文件不完整'}");
         responseMap.put("1D","{'isSuccess':false,desc:'无效的参数代码'}");
         responseMap.put("1E","{'isSuccess':false,desc:'参数未配置'}");
         responseMap.put("1F","{'isSuccess':false,desc:'用户卡号不存在'}");
         responseMap.put("20","{'isSuccess':false,desc:'用户卡号已禁用'}");
         responseMap.put("21","{'isSuccess':false,desc:'用户卡认证信息非法'}");
         responseMap.put("22","{'isSuccess':false,desc:'不允许退卡'}");
         responseMap.put("23","{'isSuccess':false,desc:'其它未定义的错误'}");
         responseMap.put("24","{'isSuccess':false,desc:'参数未下载'}");
         responseMap.put("25","{'isSuccess':false,desc:'无效的交易类型码'}");
         responseMap.put("26","{'isSuccess':false,desc:'参数版本过旧'}");
         responseMap.put("27","{'isSuccess':false,desc:'参数版本已最新'}");
         responseMap.put("50","{'isSuccess':false,desc:'系统错误'}");

        //联机报文应答
        responseMap.put("00000","{'isSuccess':true,desc:'成功'}");
        responseMap.put("00000","{'isSuccess':false,desc:'系统错误'}");

        //联机卡错误
        responseMap.put("24001","{'isSuccess':false,desc:'授权状态未审核'}");
        responseMap.put("24002","{'isSuccess':false,desc:'授权状态审核失败'}");
        responseMap.put("24003","{'isSuccess':false,desc:'授权有效截止时间'}");
        responseMap.put("24004","{'isSuccess':false,desc:'授权金额超过限额'}");
        responseMap.put("24005","{'isSuccess':false,desc:'授权信息未找到'}");

        //签到签退错误
        responseMap.put("25001","{'isSuccess':false,desc:'无效操作员'}");
        responseMap.put("25002","{'isSuccess':false,desc:'操作员密码无效'}");
        responseMap.put("25003","{'isSuccess':false,desc:'POS 终端未签到'}");
        responseMap.put("25004","{'isSuccess':false,desc:'拒绝操作员使用终端'}");
        responseMap.put("25005","{'isSuccess':false,desc:'POS 终端未签退'}");
        responseMap.put("25008","{'isSuccess':false,desc:'历史累计充值总笔数不匹配'}");
        responseMap.put("25009","{'isSuccess':false,desc:'历史累计充值总金额不匹配'}");
        responseMap.put("25010","{'isSuccess':false,desc:'调整时间出错'}");
        responseMap.put("25011","{'isSuccess':false,desc:'更新充值信息表出错'}");
        responseMap.put("25012","{'isSuccess':false,desc:'参数标记错'}");
        responseMap.put("25013","{'isSuccess':false,desc:'报文长度无效'}");
        responseMap.put("25014","{'isSuccess':false,desc:'SAM 卡号不存在'}");
        responseMap.put("25015","{'isSuccess':false,desc:'SAM 卡号已禁用'}");
        responseMap.put("25016","{'isSuccess':false,desc:'POS 终端号与 SAM 卡不匹配'}");
        responseMap.put("25017","{'isSuccess':false,desc:'POS 终端参数待更新'}");
        responseMap.put("25018","{'isSuccess':false,desc:'设备编号不存在'}");
        responseMap.put("25019","{'isSuccess':false,desc:'更新消费信息表出错'}");
        responseMap.put("25030","{'isSuccess':false,desc:'没有取得密钥'}");
        responseMap.put("25031","{'isSuccess':false,desc:'没有取得 TAC 密钥'}");
        responseMap.put("25032","{'isSuccess':false,desc:'没有取得 MAC 密钥'}");
        responseMap.put("25033","{'isSuccess':false,desc:'POS 已禁用'}");
        responseMap.put("25034","{'isSuccess':false,desc:'签到交易未获取到'}");
        responseMap.put("25035","{'isSuccess':false,desc:'网点号不存在'}");

        //客服联机错误
        responseMap.put("26001","{'isSuccess':false,desc:'卡状态无效'}");
        responseMap.put("26002","{'isSuccess':false,desc:'该卡类型不能退卡'}");
        responseMap.put("26003","{'isSuccess':false,desc:'重复申请交易'}");
        responseMap.put("26004","{'isSuccess':false,desc:'该卡已换卡'}");
        responseMap.put("26005","{'isSuccess':false,desc:'卡号不存在'}");
        responseMap.put("26006","{'isSuccess':false,desc:'记录级检查项不存在'}");
        responseMap.put("26007","{'isSuccess':false,desc:'原登记交易未找到'}");
        responseMap.put("26008","{'isSuccess':false,desc:'延迟期限未到'}");
        responseMap.put("26009","{'isSuccess':false,desc:'退卡金额大于卡帐户余额'}");
        responseMap.put("26010","{'isSuccess':false,desc:'该 POS 无做该种退换卡业务权限'}");
        responseMap.put("26011","{'isSuccess':false,desc:'该类型卡不允许受理此业务'}");
        responseMap.put("26012","{'isSuccess':false,desc:'设备编号不存在'}");
        responseMap.put("26013","{'isSuccess':false,desc:'新卡状态无效'}");
        responseMap.put("26014","{'isSuccess':false,desc:'需要在交易登记的网点做交易完成'}");
        responseMap.put("26015","{'isSuccess':false,desc:'退换卡黑名单交易'}");
        responseMap.put("26017","{'isSuccess':false,desc:'退换卡 POS 终端状态不合法'}");
        responseMap.put("26018","{'isSuccess':false,desc:'新卡卡号不存在'}");
        responseMap.put("26019","{'isSuccess':false,desc:'换卡新卡为黑名单卡'}");
        responseMap.put("26020","{'isSuccess':false,desc:' 累计新卡余额超过最大限制'}");
        responseMap.put("26021","{'isSuccess':false,desc:'用同一张卡做换卡'}");
        responseMap.put("26022","{'isSuccess':false,desc:'旧卡余额小于新卡押金'}");
        responseMap.put("26023","{'isSuccess':false,desc:'该卡已退卡'}");
        responseMap.put("26024","{'isSuccess':false,desc:'大额卡登记金额与退卡金额不符'}");
        responseMap.put("26025","{'isSuccess':false,desc:'退货原始交易不合法'}");
        responseMap.put("26026","{'isSuccess':false,desc:'退货金额大于原始交易'}");
        responseMap.put("26027","{'isSuccess':false,desc:' 退货累计金额大于原始交易'}");
        responseMap.put("26028","{'isSuccess':false,desc:'非本单位交易退货'}");
        responseMap.put("26029","{'isSuccess':false,desc:'大额卡需登记后退卡'}");
        responseMap.put("26030","{'isSuccess':false,desc:'免费换卡原卡号不存在'}");
        responseMap.put("26031","{'isSuccess':false,desc:'特种卡重复采购'}");
        responseMap.put("26040","{'isSuccess':false,desc:'验证充值 MAC1 失败'}");
        responseMap.put("26041","{'isSuccess':false,desc:'计算充值 MAC2 失败'}");
        responseMap.put("26042","{'isSuccess':false,desc:'请求交易审理状态异常'}");
        responseMap.put("26043","{'isSuccess':false,desc:'卡类型不一致'}");
        responseMap.put("26044","{'isSuccess':false,desc:'卡类型不存在'}");
        responseMap.put("26045","{'isSuccess':false,desc:'特种卡个人信息不存在'}");
        responseMap.put("26046","{'isSuccess':false,desc:'验证消费 MAC1 失败'}");
        responseMap.put("26047","{'isSuccess':false,desc:'用户卡未挂失'}");
        responseMap.put("26048","{'isSuccess':false,desc:'不允许取消申请'}");
        responseMap.put("26049","{'isSuccess':false,desc:' 申请的业务总中心尚未处理'}");
        responseMap.put("26050","{'isSuccess':false,desc:'审核数据认证失败'}");
        responseMap.put("26051","{'isSuccess':false,desc:'申请交易已被获取过'}");
        responseMap.put("26052","{'isSuccess':false,desc:'申请交易已被取消'}");
        responseMap.put("26053","{'isSuccess':false,desc:'交易后金额不能大于 1000'}");
        responseMap.put("26054","{'isSuccess':false,desc:'未找到申请类交易完成'}");
        responseMap.put("26055","{'isSuccess':false,desc:'记名信息未找到'}");
        responseMap.put("26056","{'isSuccess':false,desc:'记名交易类型错误'}");
        responseMap.put("26057","{'isSuccess':false,desc:'记名交易状态错误'}");
        responseMap.put("26058","{'isSuccess':false,desc:'不允许退卡退资换卡(实际余额+ 实际押金<0)'}");
        responseMap.put("26059","{'isSuccess':false,desc:'该卡类型不能换卡'}");
        responseMap.put("26060","{'isSuccess':false,desc:'内部交易不存在'}");
        responseMap.put("26061","{'isSuccess':false,desc:'申请交易无法撤消'}");
        responseMap.put("26062","{'isSuccess':false,desc:'申请交易无法重新获取'}");
        responseMap.put("26063","{'isSuccess':false,desc:'计算充值 KEYB 失败'}");
        responseMap.put("26064","{'isSuccess':false,desc:'该卡已挂失完成'}");
        responseMap.put("26065","{'isSuccess':false,desc:' 挂失卡和申领卡类型不一致'}");
        responseMap.put("26066","{'isSuccess':false,desc:'该卡已解挂'}");
        responseMap.put("26067","{'isSuccess':false,desc:'MAC 错'}");
        responseMap.put("26068","{'isSuccess':false,desc:' 完成类型和请求类型不一致'}");
        responseMap.put("26069","{'isSuccess':false,desc:'记名信息重复'}");
        responseMap.put("26070","{'isSuccess':false,desc:'结果获取类型和请求类型不一致'}");
        responseMap.put("26071","{'isSuccess':false,desc:'无效的业务类型'}");
        responseMap.put("26072","{'isSuccess':false,desc:'无符合条件的记录'}");
        responseMap.put("26073","{'isSuccess':false,desc:'卡已经过质保期'}");
        responseMap.put("26074","{'isSuccess':false,desc:' 解挂卡号和挂失卡号不一致'}");
        responseMap.put("26075","{'isSuccess':false,desc:'卡受理业务单位不合法'}");
        responseMap.put("26090","{'isSuccess':false,desc:'重复购买特种卡'}");
        responseMap.put("26091","{'isSuccess':false,desc:'该卡已启用记名信息'}");
        responseMap.put("26092","{'isSuccess':false,desc:'未获取到卡操作授权信息'}");
        responseMap.put("26093","{'isSuccess':false,desc:'卡操作授权信息不可冲正'}");
        responseMap.put("26094","{'isSuccess':false,desc:'重复挂失交易'}");
        responseMap.put("26095","{'isSuccess':false,desc:'重复退换卡交易'}");
        responseMap.put("26089","{'isSuccess':false,desc:'原交易已经被冲正'}");
        responseMap.put("26101","{'isSuccess':false,desc:'  消费撤销未找到消费原交易'}");
        responseMap.put("26102","{'isSuccess':false,desc:'  消费原交易处理状态不正确'}");
        responseMap.put("26103","{'isSuccess':false,desc:'  消费撤销交易和消费原交易金额不符'}");
        responseMap.put("26104","{'isSuccess':false,desc:'撤销的不是上笔消费'}");
        responseMap.put("26105","{'isSuccess':false,desc:'此卡类型不可消费'}");
        responseMap.put("26106","{'isSuccess':false,desc:'此种卡类型不允许充次'}");
        responseMap.put("26107","{'isSuccess':false,desc:'超过最大的充次次数'}");
        responseMap.put("26108","{'isSuccess':false,desc:'此种卡类型不允许充值'}");
        responseMap.put("26109","{'isSuccess':false,desc:'员工信息未找到'}");
        responseMap.put("26110","{'isSuccess':false,desc:'员工卡和员工信息未绑定'}");
        responseMap.put("26111","{'isSuccess':false,desc:'员工卡卡状态不正确'}");
        responseMap.put("26112","{'isSuccess':false,desc:'本单位无权申请该交易'}");
        responseMap.put("26113","{'isSuccess':false,desc:'此种卡类型已经不能再充值'}");
        responseMap.put("26114","{'isSuccess':false,desc:'卡片移资时原卡交易前余额 非0'}");
        responseMap.put("26115","{'isSuccess':false,desc:'充值金额太小'}");
        responseMap.put("26116","{'isSuccess':false,desc:'卡次数消费时已经过期'}");
        responseMap.put("26201","{'isSuccess':false,desc:'冻结金额不相符'}");
        responseMap.put("26202","{'isSuccess':false,desc:'无可充值金额'}");
        responseMap.put("26203","{'isSuccess':false,desc:'预充值帐户不存在'}");
        responseMap.put("26204","{'isSuccess':false,desc:'帐户可圈金额异常'}");
        responseMap.put("26205","{'isSuccess':false,desc:'帐户存在冻结金额'}");
        responseMap.put("26206","{'isSuccess':false,desc:'帐户余额密文不匹配'}");
        responseMap.put("26207","{'isSuccess':false,desc:'结果获取余额与申请获取的余额不一致'}");
        responseMap.put("26208","{'isSuccess':false,desc:'预充值帐户无可圈金额'}");
        responseMap.put("26209","{'isSuccess':false,desc:'预充值帐户无可圈金额'}");
        responseMap.put("26210","{'isSuccess':false,desc:'核销时间未到'}");
        responseMap.put("26500","{'isSuccess':false,desc:'灰交易'}");
        responseMap.put("26501","{'isSuccess':false,desc:'灰交易调整拒付'}");
        responseMap.put("26096","{'isSuccess':false,desc:'特殊卡充值参数未配置'}");
        responseMap.put("26097","{'isSuccess':false,desc:'该单位不允许该卡种充值'}");
        responseMap.put("26099","{'isSuccess':false,desc:'尚未到可充值时间'}");
        responseMap.put("26099","{'isSuccess':false,desc:'特殊卡不需要充值'}");
    }



    public static Status getResponseState(String code){
        String res=responseMap.get(code);
        JSONObject param= JSON.parseObject(res);
        String desc=param.getString("desc");
        Boolean isSuccess=param.getBoolean("isSuccess");

        Status status=new Status();
        status.setSuccess(isSuccess);
        status.setResDesc(desc);
        status.setResCode(code);

        return status;

    }


    public static class Status{
        private boolean isSuccess;
        private String resCode;
        private String resDesc;

        public boolean isSuccess() {
            return isSuccess;
        }

        public void setSuccess(boolean success) {
            isSuccess = success;
        }

        public String getResCode() {
            return resCode;
        }

        public void setResCode(String resCode) {
            this.resCode = resCode;
        }

        public String getResDesc() {
            return resDesc;
        }

        public void setResDesc(String resDesc) {
            this.resDesc = resDesc;
        }
    }



}

package com.tota.outside.rpc.socket;

import com.tota.outside.rpc.api.model.*;
import com.tota.outside.rpc.resolver.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ConnectionTemplate {

    private SocketPool pool;
    private static Map<Class, Resolver> resolverMap = new HashMap<>();

    public void setPool(SocketPool pool) {
        this.pool = pool;
    }

    static {
        resolverMap.put(ConsumeMessage.class, new ConsumeMsgResolver());
        resolverMap.put(OperateMessage.class, new OperateMsgResolver());
        resolverMap.put(RechargeMessage.class, new RechargeMsgResolver());
        resolverMap.put(RefundMessage.class, new RechargeMsgResolver());
        resolverMap.put(RollbackConsumeMessage.class, new RollbackConsumeMsgResolver());
        resolverMap.put(SignInMessage.class, new SignInMsgResolver());
        resolverMap.put(SignOutMessage.class, new SignOutMsgResolver());
        resolverMap.put(SyncTimeMessage.class, new SyncTimeMsgResolver());
    }


    /***
     * 请求socket 处理
     * @param t
     * @return
     */
    public <T> T processRequest(T t, Class<T> clazz) throws Exception {
        //获取报文解析器，并组装报文
        Resolver resolver = resolverMap.get(clazz);
        String datagram = resolver.generateDatagram(t);

        //从连接池获取 socket连接
        SocketConnection socketConnection = pool.borrowObject();

        //请求处理
        String response = socketConnection.processRequest(datagram);

        //根据响应报文，解析成java对象
        T result = (T) resolver.resolveDatagram(response);

        //请求完成放回连接池
        pool.returnObject(socketConnection);

        return result;
    }
}

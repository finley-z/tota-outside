package com.tota.outside.rpc.socket;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class SocketConnectionFactory implements PooledObjectFactory<SocketConnection> {
    private static final org.apache.commons.logging.Log log = LogFactory.getLog(SocketConnectionFactory.class);

    private String hostName;
    private int port;
    private boolean keepAlive;
    private int timeout;
    private int bufferSize;

    public SocketConnectionFactory() {
        this.keepAlive=true;
        this.timeout = 2000;
    }


    @Override
    public PooledObject<SocketConnection> makeObject() throws Exception {
        log.info("[Socket Pool] ====== Create SocketConnection By Pool ======");
        SocketConnection connection=new SocketConnection(hostName,port,timeout,keepAlive,bufferSize);
        return new DefaultPooledObject<>(connection);
    }

    @Override
    public void destroyObject(PooledObject<SocketConnection> pooledObject) throws Exception {
        log.info("[Socket Pool] ====== Destroy SocketConnection From Pool ======");
        //释放连接，关闭buffer等
        pooledObject.getObject().closeConnect();
        passivateObject(pooledObject);
        pooledObject.markAbandoned();
    }


    /**
     * 判断资源对象是否有效，有效返回 true，无效返回 false
     * 什么时候会调用此方法:
     * 1：从资源池中获取资源的时候，参数 testOnBorrow 或者 testOnCreate 中有一个 配置 为 true 时，则调用  factory.validateObject() 方法
     * 2：将资源返还给资源池的时候，参数 testOnReturn，配置为 true 时，调用此方法
     * 3：资源回收线程，回收资源的时候，参数 testWhileIdle，配置为 true 时，调用此方法
     */
    @Override
    public boolean validateObject(PooledObject<SocketConnection> pooledObject) {
        log.info("[Socket Pool] ====== Validate SocketConnection is effective======");
        return true;
    }

    /***
     *  激活资源对象   调用后连接处于忙状态
     * @param pooledObject
     * @throws Exception
     */
    @Override
    public void activateObject(PooledObject<SocketConnection> pooledObject) throws Exception {
        log.info("[Socket Pool] ====== Activate SocketConnection While Borrow From Pool======");
        pooledObject.getObject().setIdle(true);
    }

    /***
     * 钝化资源对象 调用后连接处于闲状态
     * @param pooledObject
     * @throws Exception
     */
    @Override
    public void passivateObject(PooledObject<SocketConnection> pooledObject) throws Exception {
        log.info("[Socket Pool] ====== Passivate SocketConnection Return to Pool======");
        pooledObject.getObject().setIdle(false);
    }



    // config field
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }
}

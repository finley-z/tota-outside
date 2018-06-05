package com.tota.outside.rpc.socket;

public class ConnectionTemplet {

    private SocketPool pool;


    public SocketPool getPool() {
        return pool;
    }

    public void setPool(SocketPool pool) {
        this.pool = pool;
    }

    /***
     * 请求socket 处理
     * @param datagram
     * @return
     */
    public String processRequest(String datagram) throws Exception {

        //从连接池获取 socket连接
        SocketConnection socketConnection = pool.borrowObject();
        //请求处理
        String result = socketConnection.processRequest(datagram);
        //请求完成放回连接池
        pool.returnObject(socketConnection);

        return result;
    }

}

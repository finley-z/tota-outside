package com.tota.outside.rpc.socket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

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

    public static  void  main(String [] args){
         String configPath = "classpath*:spring-config.xml";
        ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext(new String[]{configPath});
        context.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConnectionTemplet connectionTemplet =(ConnectionTemplet)context.getBean("connectionTemplet");
        try {
            String result= connectionTemplet.processRequest("030557310844000000005000102051201806050243270000000000540000280000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000201806050000002018060514432700000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
            System.out.println("server message"+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

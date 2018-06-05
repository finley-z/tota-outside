package com.tota.outside.rpc.test;

import java.net.SocketTimeoutException;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
                try {
                    throw new SocketTimeoutException("连接超时");
                } catch (SocketTimeoutException e) {
                    e.printStackTrace();
                }
                try {
                    throw new SocketTimeoutException("连接超时");
                } catch (SocketTimeoutException e) {
                    e.printStackTrace();
                }
            }
    };
    public static  void main(String[]args){
        new Timer().schedule(new TimerTaskTest().timerTask,5000);

    }
}

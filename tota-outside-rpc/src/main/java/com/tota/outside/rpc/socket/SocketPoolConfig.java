package com.tota.outside.rpc.socket;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class SocketPoolConfig  extends GenericObjectPoolConfig {
    public SocketPoolConfig() {
        this.setTestWhileIdle(true);
        this.setMinEvictableIdleTimeMillis(60000L);
        this.setTimeBetweenEvictionRunsMillis(30000L);
        this.setNumTestsPerEvictionRun(-1);
    }
}

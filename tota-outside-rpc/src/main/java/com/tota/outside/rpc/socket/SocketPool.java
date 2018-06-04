package com.tota.outside.rpc.socket;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class SocketPool extends GenericObjectPool<SocketConnection> {
    protected GenericObjectPool<SocketConnection> interPool;

    public SocketPool(PooledObjectFactory<SocketConnection> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }



}

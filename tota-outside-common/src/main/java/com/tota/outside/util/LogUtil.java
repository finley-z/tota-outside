package com.tota.outside.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    private static Logger LOG;

    private Class cls;

    public static Logger log(Class cls) {
        LOG=LoggerFactory.getLogger(cls);
         return LOG;
    }

    public  static void info(String s){
        LOG.info("fafaggdgagagagagag");
    }
}

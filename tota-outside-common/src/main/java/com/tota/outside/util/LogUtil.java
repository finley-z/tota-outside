package com.tota.outside.util;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogUtil {
    private static  Log  LOG;

    private Class cls;

    public static Log log(Class cls) {
        LOG=LogFactory.getLog(cls);
         return LOG;
    }

    public  static void info(String s){
        LOG.info("fafaggdgagagagagag");
    }
}

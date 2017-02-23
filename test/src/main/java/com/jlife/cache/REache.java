package com.jlife.cache;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by chenjianan on 2016/11/15-17:26.
 * <p>
 * Describe:
 */
public class REache implements Cache {

    Logger l=  Logger.getLogger(REache.class);

    public String getId() {
        l.info("使用REache getId");
        return null;
    }

    public void putObject(Object o, Object o1) {
        l.info("使用REache putObject");
    }

    public Object getObject(Object o) {
        l.info("使用REache getObject");
        return o;
    }

    public Object removeObject(Object o) {
        l.info("使用REache removeObject");
        return null;
    }

    public void clear() {
        l.info("使用REache clear");
    }

    public int getSize() {
        l.info("使用REache getSize");
        return 0;
    }

    public ReadWriteLock getReadWriteLock() {
        l.info("使用REache getReadWriteLock");
        return null;
    }
}

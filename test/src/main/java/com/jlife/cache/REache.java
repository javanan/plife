package com.jlife.cache;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by chenjianan on 2016/11/15-17:26.
 * <p>
 * Describe:
 */
public class REache implements Cache {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public String getId() {
        logger.info("使用REache getId");
        return null;
    }

    public void putObject(Object o, Object o1) {
        logger.info("使用REache putObject");
    }

    public Object getObject(Object o) {
        logger.info("使用REache getObject");
        return o;
    }

    public Object removeObject(Object o) {
        logger.info("使用REache removeObject");
        return null;
    }

    public void clear() {
        logger.info("使用REache clear");
    }

    public int getSize() {
        logger.info("使用REache getSize");
        return 0;
    }

    public ReadWriteLock getReadWriteLock() {
        logger.info("使用REache getReadWriteLock");
        return null;
    }
}

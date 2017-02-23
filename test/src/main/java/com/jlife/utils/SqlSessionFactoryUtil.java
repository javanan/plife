package com.jlife.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by chenjianan on 2016/11/9-20:55.
 * <p>
 * Describe:
 */
public class SqlSessionFactoryUtil {

    /**
     * 类线程锁
     */
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;
    /**
     * SqlSessionFactory对象
     */
    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 私有构造方法
     */
    private SqlSessionFactoryUtil() {
    }

    public static SqlSessionFactory initSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);


        } catch (IOException e) {
            e.fillInStackTrace();
            Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE, null, e);

        }


        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}

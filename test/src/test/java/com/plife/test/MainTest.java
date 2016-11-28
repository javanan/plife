package com.plife.test;

import com.alibaba.fastjson.JSON;
import com.plife.dao.RoleDao;
import com.plife.pojo.Role;
import com.plife.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenjianan on 2016/11/9-20:40.
 * <p>
 * Describe:
 */
public class MainTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao roleDao = sqlSession.getMapper(RoleDao.class);

            List<Role> count = roleDao.sqltest("note");
            System.out.println(JSON.toJSON(count));
        } catch (Exception e) {
            System.out.print(e.fillInStackTrace());
            System.out.print("cc");
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}

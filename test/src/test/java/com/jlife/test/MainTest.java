package com.jlife.test;

import com.alibaba.fastjson.JSON;
import com.jlife.dao.RoleDao;
import com.jlife.pojo.Role;
import com.jlife.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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

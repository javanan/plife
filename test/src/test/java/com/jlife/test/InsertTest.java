package com.jlife.test;

import com.alibaba.fastjson.JSON;
import com.jlife.dao.RoleDao;
import com.jlife.pojo.Role;
import com.jlife.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by chenjianan on 2016/11/10-14:25.
 * <p>
 * Describe:
 */
public class InsertTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleDao roleDao=sqlSession.getMapper(RoleDao.class);
            Role role=    new Role();

            role.setNote("note");
            role.setRoleName("name");
            roleDao.addRole(role);

            sqlSession.commit();
            System.out.println(JSON.toJSON(role));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
}

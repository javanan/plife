package com.plife.test;

import com.alibaba.fastjson.JSON;
import com.plife.dao.RoleDao;
import com.plife.pojo.Role;
import com.plife.utils.SqlSessionFactoryUtil;
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

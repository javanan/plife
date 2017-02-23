package com.jlife.test;

import com.alibaba.fastjson.JSON;
import com.jlife.dao.StudentDao;
import com.jlife.pojo.Student;
import com.jlife.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import static java.lang.Thread.sleep;

/**
 * Created by chenjianan on 2016/11/13-19:00.
 * <p>
 * Describe:
 */
public class AssociationTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        SqlSession sqlSession3 = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            StudentDao studentDao2 = sqlSession.getMapper(StudentDao.class);
            sqlSession3 = SqlSessionFactoryUtil.openSqlSession();

            Student student=    studentDao.getStudentById(1L);
            System.out.println(JSON.toJSON(student));
            student.setName("xxx");
            Student student1=    studentDao.getStudentById(1L);
            System.out.println(JSON.toJSON(student1));

            Student student2= studentDao2.getStudentById(1L);
            System.out.println(JSON.toJSON(student2));
            sqlSession.commit();
            final StudentDao studentDao3 = sqlSession3.getMapper(StudentDao.class);
            Student student3= studentDao3.getStudentById(1L);
            System.out.println(JSON.toJSON(student3));
            sqlSession3.commit();

            final SqlSession finalSqlSession = sqlSession3;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        sleep(1000);
                        Student student3= studentDao3.getStudentById(1L);
                        System.out.println(JSON.toJSON(student3));
                        finalSqlSession.commit();
                        System.out.println("xxxx");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            System.out.println("異常");
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}

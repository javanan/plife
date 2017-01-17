package com.plife.test;

import com.alibaba.fastjson.JSON;
import com.plife.dao.RoleDao;
import com.plife.pojo.Role;
import com.plife.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by chenjianan on 2017/1/4-19:57.
 * <p>
 * Describe:
 */
public class Ltest {
    public static void main(String[] args) {
        Long id = 1L;
        System.out.println(id == 1l);
        System.out.println("1".equals(id));
        System.out.println(13>>2<<2);


    }


}

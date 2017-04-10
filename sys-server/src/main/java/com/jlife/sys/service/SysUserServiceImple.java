package com.jlife.sys.service;

import com.jlife.sys.dao.SysUserDao;
import com.jlife.sys.entity.SysUser;

import com.jlife.base.session.SessionDAO;
import com.jlife.sys.security.SysUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by chenjianan on 2016/12/13-19:47.
 * <p>
 * Describe: 系统用户 sysUserService 的实现类
 */
@Component
public class SysUserServiceImple implements SysUserService {

    @Autowired
    private SessionDAO sessionDAO;
    @Autowired
    private SysUserDao sysUserDao;


    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @Override
    public SysUser getById(String id) {
        return SysUserUtils.getById(id);
    }

    /**
     * 根据登录名获取用户
     * @param loginName
     * @return
     */
    @Override
    public SysUser getUserByLoginName(String loginName) {
        return SysUserUtils.getByLoginName(loginName);
    }

}

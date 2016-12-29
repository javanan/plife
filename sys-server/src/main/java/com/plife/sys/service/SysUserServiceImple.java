package com.plife.sys.service;

import com.plife.sys.dao.SysUserDao;
import com.plife.sys.pojo.SysUser;

import com.plife.base.session.SessionDAO;
import com.plife.sys.security.UserUtils;
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

    public SysUser fetch(Long id) {
        sysUserDao.fetch(id);
        return null;
    }
    /**
     * 根据登录名获取用户
     * @param loginName
     * @return
     */
    public SysUser getUserByLoginName(String loginName) {
        return UserUtils.getByLoginName(loginName);
    }

}

package com.jlife.sys.service;

import com.jlife.sys.entity.SysUser;

/**
 * Created by chenjianan on 2016/12/13-19:46.
 * <p>
 * Describe: 系统用户 service接口
 */
public interface SysUserService {

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    SysUser getById(String id);


    /**
     * 根据登录名获取用户
     * @param loginName
     * @return
     */
     SysUser getUserByLoginName(String loginName);
}

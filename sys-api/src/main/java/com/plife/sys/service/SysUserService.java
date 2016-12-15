package com.plife.sys.service;

import com.plife.sys.pojo.SysUser;

/**
 * Created by chenjianan on 2016/12/13-19:46.
 * <p>
 * Describe: 系统用户 service接口
 */
public interface SysUserService {

    /**
     * 根据用户id获取用户
     * @param id
     * @return SysUser
     */
    public SysUser fetch(Long id);

}

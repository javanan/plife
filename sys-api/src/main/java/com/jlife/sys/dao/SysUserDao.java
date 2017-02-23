package com.jlife.sys.dao;

import com.jlife.sys.pojo.SysUser;
import org.springframework.stereotype.Component;

/**
 * Created by chenjianan on 2016/12/14-20:11.
 * <p>
 * Describe: 系统用户dao
 */
@Component
public interface SysUserDao {

    public SysUser fetch(Long id);

    /**
     * 根据登录名称查询用户
     * @param sysUser
     * @return
     */
    public SysUser getByLoginName(SysUser sysUser);
}

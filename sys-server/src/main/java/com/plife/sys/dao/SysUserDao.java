package com.plife.sys.dao;

import com.plife.base.annotation.MyBatisDao;
import com.plife.sys.pojo.SysUser;
import org.springframework.stereotype.Component;

/**
 * Created by chenjianan on 2016/12/14-20:11.
 * <p>
 * Describe: 系统用户dao
 */
@Component
public interface SysUserDao {
    public SysUser fetch(Long id);
}

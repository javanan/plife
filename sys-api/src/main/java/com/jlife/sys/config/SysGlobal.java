package com.jlife.sys.config;

import com.jlife.base.config.Global;

/**
 * Created by chenjianan on 2016/11/24-20:01.
 * <p>
 * Describe: sys （api）模块 全局变量配置
 */
public class SysGlobal extends Global {
    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;
}

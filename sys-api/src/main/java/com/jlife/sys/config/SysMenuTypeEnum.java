package com.jlife.sys.config;

/**
 * Created by chen on 2017/3/31.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 菜单类型 枚举类
 */
public enum SysMenuTypeEnum {
    MENU("菜单"),BUTTON("按钮");


    private final String value;
    SysMenuTypeEnum(final String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}

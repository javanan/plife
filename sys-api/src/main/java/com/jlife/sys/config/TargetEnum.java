package com.jlife.sys.config;

/**
 * Created by chen on 2017/3/31.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:  链接打开方式的枚举类
 */
public enum TargetEnum {
    _blank("新窗口打开"), _self("当前窗口打开"), _parent("在父框架集中打开被链接文档"), _top("在整个窗口中打开被链接文档");
    private final String value;

    TargetEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

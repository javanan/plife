package com.jlife.sys.entity;

import com.jlife.sys.basepojo.DataDo;

/**
 * Created by chen on 2017/4/10.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:  系统日志实体类
 */
public class SysLog extends DataDo<SysLog> {

    /**
     * varchar(64) NULL日志来源类型
     */
    private String type;
    /**
     * varchar(500) NULL模块名称
     */
    private String tag;
    /**
     * varchar(1000) NULL全类名或者操作url
     */
    private String src;
    /**
     * varchar(15) NULLip
     */
    private String ip;
    /**
     * varchar(1000) NULL信息
     */
    private String msg;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

package com.jlife.sys.entity;

import com.jlife.sys.basepojo.TreeDo;
import org.hibernate.validator.constraints.Length;

/**
 * Created by chen on 2017/3/2.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 职位entity
 */
public class SysOffice extends TreeDo<SysOffice> {


    /**
     * varchar(64)NULL编码
     */
    private String code;

    /**
     * varchar(100)NULL图标
     */
    private String icon;


    /**
     * varchar(64)NULL所在公司id
     */
    private String sysCompanyId;


    @Length(min = 0, max = 64, message = "编码长度必须介于 1 和 64 之间")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Length(min = 0, max = 1000, message = "图标路径长度必须介于 1 和 1000 之间")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Length(min = 0, max = 64, message = "公司id长度必须介于 1 和 64 之间")
    public String getSysCompanyId() {
        return sysCompanyId;
    }

    public void setSysCompanyId(String sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }
}

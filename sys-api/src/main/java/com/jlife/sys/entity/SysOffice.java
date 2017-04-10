package com.jlife.sys.entity;

import com.jlife.sys.basepojo.DataDo;
import org.hibernate.validator.constraints.Length;

/**
 * Created by chen on 2017/3/2.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 职位entity
 */
public class SysOffice extends DataDo<SysOffice> {

    /**
     * //varchar(64) NULL父id
     */
    private String parentId;
    /**
     * varchar(100) NULL组织名称
     */
    private String name;

    /**
     * varchar(64)NULL编码
     */
   private String code;

    /**
     * varchar(100)NULL图标
     */
    private  String icon;

    /**
     * varchar(1000)NULL路径
     */
    private String path;

    /**
     * int(11)NULL排序
     */
    private Integer sort;

    /**
     * varchar(64)NULL所在公司id
     */
    private String sysCompanyId;

    @Length(min=0, max=64, message="父id长度必须介于 1 和 64 之间")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Length(min=0, max=100, message="公组织名称长度必须介于 1 和 100 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min=0, max=64, message="编码长度必须介于 1 和 64 之间")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Length(min=0, max=1000, message="图标路径长度必须介于 1 和 1000 之间")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }
    @Length(min=0, max=1000, message="路径长度必须介于 1 和 1000 之间")
    public void setPath(String path) {
        this.path = path;
    }
    @Length(min=0, max=11, message="排序长度必须介于 1 和 11 之间")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    @Length(min=0, max=64, message="公司id长度必须介于 1 和 64 之间")
    public String getSysCompanyId() {
        return sysCompanyId;
    }

    public void setSysCompanyId(String sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }
}

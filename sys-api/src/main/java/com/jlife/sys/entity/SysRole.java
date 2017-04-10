package com.jlife.sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.jlife.base.entity.DataDo;
import com.jlife.sys.config.DataScopeEnum;
import com.jlife.sys.config.SysGlobal;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * Created by chenjianan on 2017/3/1-16:12.
 * <p>
 * Describe: 角色实体类DO
 */
public class SysRole extends DataDo<SysRole> {

    /**
     * varchar(64) NOT NULL角色名称
     */
    private String name;
    /**
     * varchar(64) NULL英文名称
     */
    private String code;
    /**
     * varchar(64) NULL角色类型
     */
    private String roleType;
    /**
     * varchar(64) NULL数据范围
     */
    private String dataScope;

    @JsonIgnore
    public SysCompany getSysCompany() {
        return sysCompany;
    }

    public void setSysCompany(SysCompany sysCompany) {
        this.sysCompany = sysCompany;
    }
    @Length(min=0, max=64, message="角色code长度必须介于 1 和 64 之间")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * varchar(64) NULL是否可用
     */
    private String useable;

    private SysCompany sysCompany;    // 归属公司

    private SysUser sysUser;        // 根据用户ID查询角色列表


    private List<SysMenu> sysMenuList = Lists.newArrayList(); // 拥有菜单列表

    private List<SysOffice> sysOfficeList = Lists.newArrayList(); // 按明细设置数据范围

    public SysRole() {
        super();
        this.dataScope = DataScopeEnum.DATA_SCOPE_SELF.name();
        this.useable = SysGlobal.YES;
    }

    public SysRole(String id) {
        super(id);
    }

    public SysRole(SysUser sysUser) {
        this();
        this.sysUser = sysUser;
    }

    @Length(min=0, max=64, message="角色名称长度必须介于 1 和 64 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @JsonIgnore
    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }


    public String getUseable() {
        return useable;
    }

    public void setUseable(String useable) {
        this.useable = useable;
    }


    @JsonIgnore
    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @JsonIgnore
    public List<SysMenu> getSysMenuList() {
        return sysMenuList;
    }

    public void setSysMenuList(List<SysMenu> sysMenuList) {
        this.sysMenuList = sysMenuList;
    }

    @JsonIgnore
    public List<SysOffice> getSysOfficeList() {
        return sysOfficeList;
    }

    public void setSysOfficeList(List<SysOffice> sysOfficeList) {
        this.sysOfficeList = sysOfficeList;
    }
}

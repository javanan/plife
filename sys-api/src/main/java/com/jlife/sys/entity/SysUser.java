package com.jlife.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.jlife.base.config.Global;
import com.jlife.sys.basepojo.DataDo;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

/**
 * Created by chenjianan on 2016/12/13-20:00.
 * <p>
 * Describe: 系统用户bean
 */
public class SysUser extends DataDo<SysUser> {

    private static final long serialVersionUID = 1L;

    public String getLoginName() {
        return loginName;
    }

    private String loginName;// 登录名
    private String password;// 密码
    private String no;		// 工号
    private String name;	// 姓名
    private String email;	// 邮箱
    private String phone;	// 电话
    private String mobile;	// 手机

    private String loginIp;	// 最后登陆IP
    private String oldLoginIp;	// 上次登陆IP
    private String loginFlag;	// 是否允许登陆
    private String photo;	// 头像



    private SysRole sysRole;	// 根据角色查询用户条件
    private List<SysRole> sysRoleList = Lists.newArrayList(); // 拥有角色列表

    private SysCompany sysCompany;	// 归属公司

    @JsonIgnore
    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    @JsonIgnore
    public List<SysRole> getSysRoleList() {
        return sysRoleList;
    }

    public void setSysRoleList(List<SysRole> sysRoleList) {
        this.sysRoleList = sysRoleList;
    }

    @JsonIgnore
    public SysCompany getSysCompany() {
        return sysCompany;
    }

    public void setSysCompany(SysCompany sysCompany) {
        this.sysCompany = sysCompany;
    }

    public SysUser() {
        super();
        this.loginFlag = Global.YES;
    }

    public SysUser(String id){
        super(id);
    }

    public SysUser(String id, String loginName){
        super(id);
        this.loginName = loginName;
    }



    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }


    public String getId() {
        return id;
    }


    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @JsonIgnore
    @Length(min=1, max=100, message="密码长度必须介于 1 和 100 之间")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Length(min=1, max=100, message="姓名长度必须介于 1 和 100 之间")

    public String getName() {
        return name;
    }

    @Length(min=1, max=100, message="工号长度必须介于 1 和 100 之间")

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Email(message="邮箱格式不正确")
    @Length(min=0, max=200, message="邮箱长度必须介于 1 和 100 之间")

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(min=0, max=200, message="电话长度必须介于 1 和 20 之间")

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Length(min=0, max=200, message="手机长度必须介于 1 和 20 之间")

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public Date getCreateDate() {
        return createDate;
    }


    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }



    public String getOldLoginIp() {
        if (oldLoginIp == null){
            return loginIp;
        }
        return oldLoginIp;
    }

    public void setOldLoginIp(String oldLoginIp) {
        this.oldLoginIp = oldLoginIp;
    }



    /**
     * 用户拥有的角色名称字符串, 多个角色名称用','分隔.
     */


    public boolean isAdmin(){
        return isAdmin(this.id);
    }

    public static boolean isAdmin(String id){

        return id != null && "1".equals(id);
    }



}

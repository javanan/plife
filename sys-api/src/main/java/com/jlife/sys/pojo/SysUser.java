package com.jlife.sys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jlife.base.config.Global;
import com.jlife.sys.basepojo.DataEntity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * Created by chenjianan on 2016/12/13-20:00.
 * <p>
 * Describe: 系统用户bean
 */
public class SysUser extends DataEntity<SysUser>{

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
    private String userType;// 用户类型
    private String loginIp;	// 最后登陆IP
    private Date loginDate;	// 最后登陆日期
    private String loginFlag;	// 是否允许登陆
    private String photo;	// 头像

    private String oldLoginName;// 原登录名
    private String newPassword;	// 新密码

    private String oldLoginIp;	// 上次登陆IP
    private Date oldLoginDate;	// 上次登陆日期



    public SysUser() {
        super();
        this.loginFlag = Global.YES;
    }

    public SysUser(Long id){
        super(id);
    }

    public SysUser(Long id, String loginName){
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


    public Long getId() {
        return id;
    }

    public void preInsert() {

    }

    public void preUpdate() {

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
    @Length(min=0, max=200, message="邮箱长度必须介于 1 和 200 之间")

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(min=0, max=200, message="电话长度必须介于 1 和 200 之间")

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Length(min=0, max=200, message="手机长度必须介于 1 和 200 之间")

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getRemarks() {
        return remarks;
    }

    @Length(min=0, max=100, message="用户类型长度必须介于 1 和 100 之间")

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getOldLoginName() {
        return oldLoginName;
    }

    public void setOldLoginName(String oldLoginName) {
        this.oldLoginName = oldLoginName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getOldLoginDate() {
        if (oldLoginDate == null){
            return loginDate;
        }
        return oldLoginDate;
    }

    public void setOldLoginDate(Date oldLoginDate) {
        this.oldLoginDate = oldLoginDate;
    }



    /**
     * 用户拥有的角色名称字符串, 多个角色名称用','分隔.
     */


    public boolean isAdmin(){
        return isAdmin(this.id);
    }

    public static boolean isAdmin(Long id){
        return id==1L;
       // return id != null && "1".equals(id);
    }


}
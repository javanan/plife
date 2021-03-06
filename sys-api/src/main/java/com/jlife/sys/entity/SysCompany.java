package com.jlife.sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jlife.base.entity.DataDo;
import org.hibernate.validator.constraints.Length;

/**
 * Created by chen on 2017/3/31.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 公司信息表
 */
public class SysCompany extends DataDo<SysCompany> {

    /**
     * varchar(500) NULL公司地址
     */
    private String address;
    /**
     * varchar(64) NULL区域id
     */
    private SysArea sysArea;
    /**
     * varchar(10) NULL邮政编码
     */
    private String zipCode;
    /**
     * varchar(20) NULL法人
     */
    private String master;
    /**
     * varchar(20) NULL联系电话
     */
    private String phone;
    /**
     * varchar(20) NULL传真
     */
    private String fax;
    /**
     * varchar(100) NULL邮箱
     */
    private String email;
    /**
     * varchar(100) NULL版权信息
     */
    private String appCopyright;
    /**
     * varchar(100) NULL公司名称
     */
    private String name;

    @Length(min = 0, max = 500, message = "公司地址长度必须介于 1 和 500 之间")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonIgnore
    public SysArea getSysArea() {
        return sysArea;
    }

    public void setSysArea(SysArea sysArea) {
        this.sysArea = sysArea;
    }

    @Length(min = 0, max = 10, message = "邮政编码长度必须介于 1 和 10 之间")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Length(min = 0, max = 20, message = "法人名称长度必须介于 1 和 20 之间")
    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Length(min = 0, max = 20, message = "电话长度必须介于 1 和 20 之间")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Length(min = 0, max = 20, message = "传真号码长度必须介于 1 和 20 之间")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Length(min = 0, max = 100, message = "邮件地址长度必须介于 1 和 100 之间")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(min = 0, max = 100, message = "版权信息长度必须介于 1 和 100 之间")
    public String getAppCopyright() {
        return appCopyright;
    }

    public void setAppCopyright(String appCopyright) {
        this.appCopyright = appCopyright;
    }

    @Length(min = 0, max = 20, message = "公司名称长度必须介于 1 和 20 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

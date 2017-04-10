/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.jlife.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jlife.base.util.IdGen;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 数据Entity类
 * @param <T>
 */
public abstract class DataDo<T> extends BaseDo<T> {

	private static final long serialVersionUID = 1L;
	

	protected String createId;	// 创建者
	protected Date createDate;	// 创建日期
	protected String updateId;	// 更新者
	protected Date updateDate;	// 更新日期
	protected String delFlag; 	// 删除标记（Y：正常；N：删除；A：审核；）
	protected String remark;	// 备注


	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preInsert(String insertUserId){
		// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
		if (!this.isNewRecord){
			setId(IdGen.uuid());
		}

		if (StringUtils.isNotBlank(insertUserId)){
			this.updateId = insertUserId;
			this.createId = insertUserId;
		}
		this.updateDate = new Date();
		this.createDate = this.updateDate;
	}

	/**
	 * 更新之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdate(String updateUserId){

		if (StringUtils.isNotBlank(updateUserId)){
			this.updateId = updateUserId;
		}
		this.updateDate = new Date();
	}

	@JsonIgnore
	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@JsonIgnore
	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public DataDo() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;

	}

	public DataDo(String id) {
		super(id);
	}

	
	/**
	 * 更新之前执行方法，需要手动调用
	 */

	
	@Length(min=0, max=500,message="备注信息长度必须介于 1 和 500 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@JsonIgnore
	@Length(min=1, max=1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}

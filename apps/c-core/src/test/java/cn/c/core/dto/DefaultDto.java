package cn.c.core.dto;

import java.util.Date;


public class DefaultDto {
	
	
	/**
	 * 创建用户编号
	 */
	private String createUserCode;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后更新用户编号
	 */
	private String updateUserCode;
	/**
	 * 最后更新时间
	 */
	private Date updateTime;
	
	
	public String getCreateUserCode() {
		return createUserCode;
	}
	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUserCode() {
		return updateUserCode;
	}
	public void setUpdateUserCode(String updateUserCode) {
		this.updateUserCode = updateUserCode;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}

package cn.c.core.dto;

import java.util.Date;

import cn.c.core.domain.Task;



public class TaskDto extends DefaultDto {


	/**
	 * code 任务编号
	 */
	private String code;
	/**
	 * name 任务标题
	 */
	private String name;
	
	private TaskDto parent;
	
	private Task parent1;
	
	private Integer type;
	
	private boolean delete;
	
	private Date date;
	
	private String domainNotExist;
	

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	

	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TaskDto getParent() {
		return parent;
	}
	public void setParent(TaskDto parent) {
		this.parent = parent;
	}
	public Task getParent1() {
		return parent1;
	}
	public void setParent1(Task parent1) {
		this.parent1 = parent1;
	}
	public String getDomainNotExist() {
		return domainNotExist;
	}
	public void setDomainNotExist(String domainNotExist) {
		this.domainNotExist = domainNotExist;
	}
	
}

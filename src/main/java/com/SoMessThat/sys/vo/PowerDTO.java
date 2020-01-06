package com.SoMessThat.sys.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = "handler")
public class PowerDTO implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5238415670933714020L;

	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 图表
	 */
	private String icon;
	
	/**
	 * 动作
	 */
	private String jump;
	
	/**
	 * 名称
	 */
	private String name;
	
//	/**
//	 * 名称
//	 */
//	private String id;
//	
//	/**
//	 * 名称
//	 */
//	private Long userId;
	
	/**
	 * 子权限
	 */
	private List<PowerDTO> list;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PowerDTO> getList() {
		return list;
	}

	public void setList(List<PowerDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "{title=" + title + ", jump=" + jump + ", name=" + name + "}";
	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
	
}

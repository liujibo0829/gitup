package com.baa.dailyreport.pojo;

import java.io.Serializable;

public class Menu implements Serializable {

	private static final long serialVersionUID = 4321163504216535098L;
	private Integer menuId;
	private Integer menuMenuId;
	private String parentName;
	private String menuName;
	private String menuUrl;
	private String menuDesc;
	private String menuMark;
	private String menuInfoUrl;
	// 判断是否有子节点 有 1 无 0
	private String isMark;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMenuMenuId() {
		return menuMenuId;
	}

	public void setMenuMenuId(Integer menuMenuId) {
		this.menuMenuId = menuMenuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getMenuMark() {
		return menuMark;
	}

	public void setMenuMark(String menuMark) {
		this.menuMark = menuMark;
	}

	public String getIsMark() {
		return isMark;
	}

	public void setIsMark(String isMark) {
		this.isMark = isMark;
	}

	public String getMenuInfoUrl() {
		return menuInfoUrl;
	}

	public void setMenuInfoUrl(String menuInfoUrl) {
		this.menuInfoUrl = menuInfoUrl;
	}
}

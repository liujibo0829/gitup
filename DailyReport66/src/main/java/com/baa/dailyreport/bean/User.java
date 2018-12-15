package com.baa.dailyreport.bean;

import java.io.Serializable;

/**
 * user表的实体类
 * 
 * @author BridgeJiang 2018年7月4日09:20:52
 */
public class User implements Serializable {

	private static final long serialVersionUID = 2822301933328793056L;
	private String userid;
	private String username;
	private String userpassword;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
}

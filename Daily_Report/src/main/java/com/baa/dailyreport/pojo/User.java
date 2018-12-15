package com.baa.dailyreport.pojo;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 6877670167407406206L;
	private Integer userId;
	private Integer deptId;
	private Integer roleId;
	private Integer userUserId;
	private String pName;
	private String userName;
	private String userAccount;
	private String userPassword;
	private String userMark;
	private Role role;
	private Dept dept;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserUserId() {
		return userUserId;
	}

	public void setUserUserId(Integer userUserId) {
		this.userUserId = userUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getUserMark() {
		return userMark;
	}

	public void setUserMark(String userMark) {
		this.userMark = userMark;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}

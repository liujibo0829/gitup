package com.baa.dailyreport.pojo;

import java.io.Serializable;

/**
 * role表实体类
 * 
 * @author jiangqiao
 *
 */
public class Role implements Serializable {

	private static final long serialVersionUID = -1054699070057256025L;
	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private String roleMark;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleMark() {
		return roleMark;
	}

	public void setRoleMark(String roleMark) {
		this.roleMark = roleMark;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", roleMark=" + roleMark
				+ "]";
	}

}

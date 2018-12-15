package com.baa.dailyreport.pojo;

import java.io.Serializable;

public class Dept implements Serializable {

	private static final long serialVersionUID = 3564871692121589325L;
	private Integer deptId;
	private Integer deptDeptId;
	private String deptName;
	private String deptLocal;
	private Integer deptLevel;
	private String deptMark;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getDeptDeptId() {
		return deptDeptId;
	}

	public void setDeptDeptId(Integer deptDeptId) {
		this.deptDeptId = deptDeptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLocal() {
		return deptLocal;
	}

	public void setDeptLocal(String deptLocal) {
		this.deptLocal = deptLocal;
	}

	public Integer getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(Integer deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getDeptMark() {
		return deptMark;
	}

	public void setDeptMark(String deptMark) {
		this.deptMark = deptMark;
	}

}

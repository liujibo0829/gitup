package com.baa.dailyreport.dao;

import java.util.List;

import com.baa.dailyreport.pojo.Dept;

public interface DeptDao {


	public List<Dept> queryDept(Dept dept);

	public boolean addDept(Dept dept);

	public Dept findDeptById(Integer deptId);

	public boolean updateDept(Dept dept);

	public boolean deleteDept(Dept dept);

}

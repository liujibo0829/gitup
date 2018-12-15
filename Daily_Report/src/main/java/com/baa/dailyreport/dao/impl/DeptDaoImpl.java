package com.baa.dailyreport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baa.dailyreport.dao.DeptDao;
import com.baa.dailyreport.dao.Mark;
import com.baa.dailyreport.pojo.Dept;

@Service
public class DeptDaoImpl implements DeptDao {

	@Autowired
	private DeptDao deptDao;

	public List<Dept> queryDept(Dept dept) {
		dept.setDeptMark(Mark.DB_YES);
		return deptDao.queryDept(dept);
	}


	public boolean addDept(Dept dept) {
		if (dept != null) {
			dept.setDeptMark(Mark.DB_YES);
			deptDao.addDept(dept);
		}
		return false;
	}

	@Override
	public Dept findDeptById(Integer deptId) {
		return deptDao.findDeptById(deptId);
	}

	public boolean updateDept(Dept dept) {
		if (dept != null && dept.getDeptId() != null) {
			Dept deptin = new Dept();
			deptin.setDeptId(dept.getDeptId());
			Dept deptinfo = deptDao.findDeptById(deptin.getDeptId());
			if (deptinfo != null) {
				deptinfo.setDeptId(dept.getDeptId());
				deptinfo.setDeptName(dept.getDeptName());
				deptinfo.setDeptDeptId(dept.getDeptDeptId());
				deptinfo.setDeptLocal(dept.getDeptLocal());
				deptinfo.setDeptLevel(dept.getDeptLevel());
				return deptDao.updateDept(deptinfo);
			}
		}
		return false;
	}

	public boolean deleteDept(Dept dept) {
		if (dept != null && dept.getDeptId() != null) {
			Dept deptId = new Dept();
			deptId.setDeptId(dept.getDeptId());
			Dept deptInfo = deptDao.findDeptById(deptId.getDeptId());
			if (deptInfo != null) {
				deptInfo.setDeptMark(Mark.DB_NO);
				return deptDao.deleteDept(deptInfo);
			}
		}
		return false;
	}

}

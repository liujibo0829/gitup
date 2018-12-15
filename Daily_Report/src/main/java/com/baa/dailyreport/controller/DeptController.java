package com.baa.dailyreport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.baa.dailyreport.dao.Mark;
import com.baa.dailyreport.dao.impl.DeptDaoImpl;
import com.baa.dailyreport.pojo.Dept;

import net.sf.json.JSONArray;

@Controller
public class DeptController {

	@Autowired
	private DeptDaoImpl deptDaoImpl;

	@RequestMapping(value = "deptlist")
	public String listDept(HttpServletRequest request, Dept dept) {
		String deptName = dept.getDeptName();
		request.setAttribute("deptName", deptName);
		
		Dept de = new Dept();
		List<Dept> deptl = deptDaoImpl.queryDept(de);
		JSONArray json = JSONArray.fromObject(deptl);
		String dep = json.toString();
		request.setAttribute("de", dep);
		
		List<Dept> deptList = deptDaoImpl.queryDept(dept);
		request.setAttribute("deptList", deptList);
		return "dept_list";
	}

	@RequestMapping(value = "addDept")
	public String addDept(HttpServletRequest request) {
		Dept dept = new Dept();
		dept.setDeptMark(Mark.DB_YES);
		List<Dept> deptAll = deptDaoImpl.queryDept(dept);
		request.setAttribute("dlist", deptAll);
		return "dept_add";
	}

	@RequestMapping(value = "deptAdd", method = RequestMethod.POST)
	public String deptAdd(Dept dept) {
		deptDaoImpl.addDept(dept);
		return "redirect:deptlist";
	}

	@RequestMapping(value = "updateDept")
	public String updateDept(HttpServletRequest request,
			@RequestParam(value = "deptId", required = true) Integer deptId) {
		Dept dept = deptDaoImpl.findDeptById(deptId);
		request.setAttribute("deptone", dept);
		Dept deptlist = new Dept();
		dept.setDeptMark(Mark.DB_YES);
		List<Dept> deptAll = deptDaoImpl.queryDept(deptlist);
		request.setAttribute("deptAll", deptAll);
		return "dept_update";
	}

	@RequestMapping(value = "deptupdate", method = RequestMethod.POST)
	public String deptUpdate(Dept dept) {
		deptDaoImpl.updateDept(dept);
		return "redirect:deptlist";
	}

	@RequestMapping(value = "delDept")
	public String delDept(Dept dept) {
		deptDaoImpl.deleteDept(dept);
		return "redirect:deptlist";
	}

}

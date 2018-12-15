package com.baa.dailyreport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.baa.dailyreport.dao.impl.RoleDaoImpl;
import com.baa.dailyreport.pojo.Role;

@Controller
public class RoleController {
	@Autowired
	private RoleDaoImpl roleDaoImpl;

	@RequestMapping(value = "roleList")
	public String roleOList(HttpServletRequest request, Role role) {
		List<Role> roleList = roleDaoImpl.queryRole(role);
		request.setAttribute("rolelist", roleList);

		String roleName = role.getRoleName();
		request.setAttribute("roleName", roleName);
		return "role_list";
	}

	/*
	 * @RequestMapping(value = "rolelist") public String json(Role role) {
	 * List<Role> roleList = roleDaoImpl.queryRole(role);
	 * System.out.println("1212121112"); System.out.println(roleList.size());
	 * JSONArray r = JSONArray.fromObject(roleList); String rol = r.toString();
	 * System.out.println(rol); return rol; }
	 */

	@RequestMapping(value = "roleAdd")
	public String roleAdd() {
		return "role_add";
	}

	@RequestMapping(value = "addRole", method = RequestMethod.POST)
	public String addRole(Role role) {
		roleDaoImpl.addRole(role);
		return "redirect:roleList";
	}

	@RequestMapping(value = "updateRole")
	public String updateRole(@RequestParam(value = "roleId") Integer roleId,
			HttpServletRequest request) {
		Role role = roleDaoImpl.findRoleById(roleId);
		request.setAttribute("role", role);
		return "role_update";
	}

	@RequestMapping(value = "roleUpdate", method = RequestMethod.POST)
	public String roleUpdate(Role role) {
		roleDaoImpl.updateRole(role);
		return "redirect:roleList";
	}

	@RequestMapping(value = "deleterole")
	public String deleterole(Role role) {
		roleDaoImpl.deleteRole(role);
		return "redirect:roleList";
	}
}

package com.baa.dailyreport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.baa.dailyreport.dao.Mark;
import com.baa.dailyreport.dao.impl.MenuDaoImpl;
import com.baa.dailyreport.dao.impl.RoleDaoImpl;
import com.baa.dailyreport.dao.impl.RoleMenuDaoImpl;
import com.baa.dailyreport.pojo.Menu;
import com.baa.dailyreport.pojo.Role;
import com.baa.dailyreport.pojo.RoleMenu;

import net.sf.json.JSONArray;

@Controller
public class PowerChangeController {

	@Autowired
	private RoleDaoImpl roleDaoImpl;

	@Autowired
	private MenuDaoImpl menuDaoImpl;

	@Autowired
	private RoleMenuDaoImpl roleMenuDaoImpl;

	@RequestMapping(value = "listrole")
	public String roleList(HttpServletRequest request) {
		Role role = new Role();
		role.setRoleMark(Mark.DB_YES);
		List<Role> roleList = roleDaoImpl.queryRole(role);
		request.setAttribute("rolelist", roleList);
		return "powerchange_list";
	}

	@RequestMapping(value = "changelist")
	public String changelist(HttpServletRequest request,
			@RequestParam(value = "roleId", required = true) Integer roleId) {
		// 根据编号查询角色信息
		Role role = roleDaoImpl.findRoleById(roleId);
		request.setAttribute("role", role);
		// 菜单管理的业务逻辑
		List<Menu> list = menuDaoImpl.queryAllMenu();
		request.setAttribute("list", list);
		
		JSONArray menulist = JSONArray.fromObject(list);
		String menuli = menulist.toString();
		request.setAttribute("menulist", menuli);
		
		List<RoleMenu> rmlist = roleMenuDaoImpl.queryAll(roleId);
		request.setAttribute("rmlist", rmlist);
		
		JSONArray menuArray = JSONArray.fromObject(rmlist);
		String menuinfo = menuArray.toString();
		request.setAttribute("menuinfo", menuinfo);
		
		return "power_change";
	}

	@RequestMapping(value = "change", method = RequestMethod.POST)
	public String change(HttpServletRequest request, @RequestParam(value = "roleId", required = true) Integer roleId) {
		String[] menuIds = request.getParameterValues("menuId");
		roleMenuDaoImpl.delete(roleId);
		if (menuIds != null && menuIds.length > 0) {
			for (String menuId : menuIds) {
				RoleMenu rm = new RoleMenu();
				if (menuId != null && menuId != "") {
					rm.setMenuId(Integer.parseInt(menuId));
				}
				rm.setRoleId(roleId);
				roleMenuDaoImpl.addRoleMenu(rm);
			}
		}
		return "redirect:listrole";
	}
}

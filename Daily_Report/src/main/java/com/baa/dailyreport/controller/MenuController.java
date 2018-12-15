package com.baa.dailyreport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.baa.dailyreport.dao.impl.MenuDaoImpl;
import com.baa.dailyreport.pojo.Menu;

import net.sf.json.JSONArray;

@Controller
public class MenuController {
	@Autowired
	private MenuDaoImpl menuDaoImpl;

	@RequestMapping(value = "menu_main")
	public String menuMain(HttpServletRequest request) {
		return "menu_main";
	}

	@RequestMapping(value = "menu_left")
	public String menuLeft(HttpServletRequest request) {
		List<Menu> menulist = menuDaoImpl.queryAllMenu();
		JSONArray menuArray = JSONArray.fromObject(menulist);
		String menuObj = menuArray.toString();
		request.setAttribute("menuObj", menuObj);
		return "menu_left";
	}

	@RequestMapping(value = "menu_right")
	public String menuRight() {
		return "menu_right";
	}

	@RequestMapping(value = "menu_show")
	public String menuShow(HttpServletRequest request,
			@RequestParam(value = "menuId", required = true) Integer menuId) {
		// 查询菜单信息
		Menu menu = menuDaoImpl.findMenuById(menuId);
		// 查询父级菜单名称
		Menu menuName = menuDaoImpl.findMenuById(menu.getMenuMenuId());
		if (menuName != null) {
			menu.setParentName(menuName.getMenuName());
		}
		// 查询菜单是否有子菜单
		List<Menu> child = menuDaoImpl.findMenuByPid(menuId);
		if (child != null && child.size() > 0) {
			menu.setIsMark("1");
		} else {
			menu.setIsMark("0");
		}
		request.setAttribute("menuinfo", menu);
		return "menu_show";
	}

	@RequestMapping(value = "addMenu")
	public String registry(HttpServletRequest request,
			@RequestParam(value = "menuId", required = true) Integer menuId) {
		Menu menu = menuDaoImpl.findMenuById(menuId);
		List<Menu> pid = menuDaoImpl.queryAllMenu();
		Integer url = menuDaoImpl.queryAll().getMenuId() + 1;
		String urlId = "/menu_show?menuId=" + url;
		request.setAttribute("url", urlId);
		request.setAttribute("pmenu", pid);
		request.setAttribute("menuId", menu);
		return "menu_add";
	}

	@RequestMapping(value = "menuAdd", method = RequestMethod.POST)
	public String register(HttpServletRequest request, Menu menu) throws Exception {
		menuDaoImpl.addMenu(menu);
		return "menu_main";
	}

	@RequestMapping(value = "menu")
	public String listMenu() {
		return "menu_main";
	}

	@RequestMapping(value = "upMenu")
	public String upUser(HttpServletRequest request, @RequestParam(value = "menuId", required = true) Integer menuId)
			throws Exception {
		Menu menu = menuDaoImpl.findMenuById(menuId);
		List<Menu> pid = menuDaoImpl.queryAllMenu();
		request.setAttribute("pid", pid);
		request.setAttribute("menuone", menu);
		return "menu_update";
	}

	@RequestMapping(value = "updateMenu", method = RequestMethod.POST)
	public String modifyUser(Menu menu) {
		System.out.println("--------"+menu.getMenuMenuId());
		menuDaoImpl.updateMenu(menu);
		return "redirect:" + menu.getMenuInfoUrl();
	}

	@RequestMapping(value = "delete")
	public String delete(Menu menu) {
		menuDaoImpl.deleteMenu(menu);
		return "redirect:menu_left";
	}
}

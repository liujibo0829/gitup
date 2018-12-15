package com.baa.dailyreport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baa.dailyreport.dao.Mark;
import com.baa.dailyreport.dao.MenuDao;
import com.baa.dailyreport.pojo.Menu;

@Service
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> queryAllMenu() {
		return menuDao.queryAllMenu();
	}

	@Override
	public Menu queryAll() {
		return menuDao.queryAll();
	}

	@Override
	public boolean updateMenu(Menu menu) {
		if (menu != null && menu.getMenuId() != null) {
			Menu m = new Menu();
			m.setMenuId(menu.getMenuId());
			Menu me = menuDao.findMenuById(menu.getMenuId());
			if (me != null) {
				me.setMenuId(menu.getMenuId());
				me.setMenuName(menu.getMenuName());
				me.setMenuMenuId(menu.getMenuMenuId());
				me.setMenuInfoUrl(menu.getMenuInfoUrl());
				me.setMenuUrl(menu.getMenuUrl());
				me.setMenuDesc(menu.getMenuDesc());
				return menuDao.updateMenu(me);
			}
		}
		return false;
	}

	public boolean addMenu(Menu menu) {
		if (menu != null) {
			menu.setMenuMark(Mark.DB_YES);
			System.out.println("----"+menu.getMenuMenuId());
			return menuDao.addMenu(menu);
		}
		return false;
	}

	@Override
	public Menu findMenuById(Integer menuId) {
		return menuDao.findMenuById(menuId);
	}

	@Override
	public Menu getMenu(Menu menu) {
		return menuDao.getMenu(menu);
	}

	public boolean deleteMenu(Menu menu) {
		if (menu != null && menu.getMenuId() != null) {
			Menu men = new Menu();
			men.setMenuId(menu.getMenuId());
			Menu menuinfo = menuDao.findMenuById(men.getMenuId());
			if (menuinfo != null) {
				menuinfo.setMenuMark(Mark.DB_NO);
				return menuDao.deleteMenu(menuinfo);
			}
		}
		return false;
	}

	@Override
	public List<Menu> findMenuByPid(Integer menuId) {
		return menuDao.findMenuByPid(menuId);
	}

}

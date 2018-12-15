package com.baa.dailyreport.dao;

import java.util.List;

import com.baa.dailyreport.pojo.Menu;

public interface MenuDao {

	public List<Menu> queryAllMenu();

	public Menu queryAll();

	public boolean updateMenu(Menu menu);

	public boolean addMenu(Menu menu);

	public Menu findMenuById(Integer menuId);

	public Menu getMenu(Menu menu);

	public boolean deleteMenu(Menu menu);

	public List<Menu> findMenuByPid(Integer menuId);

}

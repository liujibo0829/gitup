package com.baa.dailyreport.dao;

import java.util.List;

import com.baa.dailyreport.pojo.RoleMenu;

public interface RoleMenuDao {

	public List<RoleMenu> queryAll(Integer roleId);

	public List<RoleMenu> findMenu(Integer roleId);

	public boolean addRoleMenu(RoleMenu roleMenu);

	public boolean delete(Integer roleId);
}

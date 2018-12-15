package com.baa.dailyreport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baa.dailyreport.dao.RoleMenuDao;
import com.baa.dailyreport.pojo.RoleMenu;

@Service
public class RoleMenuDaoImpl implements RoleMenuDao {
	
	@Autowired
	private RoleMenuDao roleMenuDao;

	@Override
	public List<RoleMenu> queryAll(Integer roleId) {
		return roleMenuDao.queryAll(roleId);
	}

	@Override
	public List<RoleMenu> findMenu(Integer roleId) {
		return roleMenuDao.findMenu(roleId);
	}

	@Override
	public boolean addRoleMenu(RoleMenu roleMenu) {
		return roleMenuDao.addRoleMenu(roleMenu);
	}

	@Override
	public boolean delete(Integer roleId) {
		return roleMenuDao.delete(roleId);
	}

}

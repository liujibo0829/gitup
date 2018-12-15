package com.baa.dailyreport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baa.dailyreport.dao.Mark;
import com.baa.dailyreport.dao.RoleDao;
import com.baa.dailyreport.pojo.Role;

@Service
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private RoleDao roleDao;

	public List<Role> queryRole(Role role) {
		role.setRoleMark(Mark.DB_YES);
		return roleDao.queryRole(role);
	}

	public boolean addRole(Role role) {
		if (role != null) {
			role.setRoleMark(Mark.DB_YES);
			return roleDao.addRole(role);
		}
		return false;
	}

	public boolean updateRole(Role role) {
		if (role != null && role.getRoleId() != null) {
			Role r = new Role();
			r.setRoleId(role.getRoleId());
			Role roleinfo = roleDao.findRoleById(r.getRoleId());
			if (roleinfo != null) {
				roleinfo.setRoleId(role.getRoleId());
				roleinfo.setRoleName(role.getRoleName());
				roleinfo.setRoleDesc(role.getRoleDesc());
				return roleDao.updateRole(role);
			}
		}
		return false;
	}

	@Override
	public Role findRoleById(Integer roleId) {
		return roleDao.findRoleById(roleId);
	}

	public boolean deleteRole(Role role) {
		if (role != null && role.getRoleId() != null) {
			Role r = new Role();
			r.setRoleId(role.getRoleId());
			Role roleinfo = roleDao.findRoleById(r.getRoleId());
			if (roleinfo != null) {
				roleinfo.setRoleMark(Mark.DB_NO);
				return roleDao.deleteRole(roleinfo);
			}
		}
		return false;
	}

}

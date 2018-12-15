package com.baa.dailyreport.dao;

import java.util.List;

import com.baa.dailyreport.pojo.Role;

/**
 * 角色信息管理的数据访问类
 * 
 * @author jiangqiao
 *
 */
public interface RoleDao {

	public boolean addRole(Role role);

	public List<Role> queryRole(Role role);
	
	public boolean updateRole(Role role);

	public Role findRoleById(Integer roleId);

	public boolean deleteRole(Role role);


}

package com.baa.dailyreport.dao;

import java.util.List;

import com.baa.dailyreport.bean.User;

public interface UserDao {

	/**
	 * 查找单个用户信息
	 * 
	 * @return
	 */
	public User findUserById(String userId) throws Exception;

	/**
	 * 查找所有信息
	 * 
	 * @return
	 */
	public List<User> queryAll() throws Exception;
	

}

package com.baa.dailyreport.dao;

public interface UserLoginDao {

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public Integer login(String userId,String userPassword) throws Exception;

}

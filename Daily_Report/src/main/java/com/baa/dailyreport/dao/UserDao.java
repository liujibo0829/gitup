package com.baa.dailyreport.dao;

import java.util.List;

import com.baa.dailyreport.pojo.User;

public interface UserDao {

	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */

	public List<User> queryAllUser(User user);

	/**
	 * 注册用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user);

	/**
	 * 通过账户查找用户
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public User findUserByAccount(String Account);

	/**
	 * 通过id查找用户
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<User> findUserById(Integer userId);

	/**
	 * 通过名字查找用户
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public User findUserByName(String userName);

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean updateUser(User user);

	/**
	 * 修改密码
	 * 
	 * @param user
	 * @return
	 */
	public boolean upPassword(User user);
	
	public boolean delUser(User user);

}

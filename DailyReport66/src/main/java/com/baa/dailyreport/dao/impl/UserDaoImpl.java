package com.baa.dailyreport.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baa.dailyreport.bean.User;
import com.baa.dailyreport.dao.UserDao;

@Service
public class UserDaoImpl implements UserDao {
	private UserDao userDao;

	/**
	 * 获取查询的信息
	 * 
	 * @throws Exception
	 */
	@Override
	public List<User> queryAll() throws Exception {
		List<User> list = userDao.queryAll();
		return list;
	}

	@Override
	public User findUserById(String userId) throws Exception {
		User user = userDao.findUserById(userId);
		System.out.println("--------------------------3");
		System.out.println(user.getUsername());
		return user;
	}
}

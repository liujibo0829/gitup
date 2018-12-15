package com.baa.dailyreport.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baa.dailyreport.bean.User;
import com.baa.dailyreport.dao.UserDao;
import com.baa.dailyreport.dao.UserLoginDao;

@Service
public class UserLoginImpl implements UserLoginDao {
	@Autowired
	private UserDao userDao;

	@Override
	public Integer login(String userId,String userPassword) throws Exception {
		System.out.println("---------------1");
		User users = userDao.findUserById(userId);
		if (users == null) {
			System.out.println("---------------2");
			return 0; // 用户不存在就返回0
		} else {
			if (userPassword.equals(users.getUserpassword())) {
				System.out.println("---------------5");
				return 2; // 用户密码正确返回2
			} else {
				System.out.println("---------------8");
				return 1; // 用户密码错误返回1
			}
		}
	}

}

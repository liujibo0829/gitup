package com.baa.dailyreport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baa.dailyreport.dao.Mark;
import com.baa.dailyreport.dao.UserDao;
import com.baa.dailyreport.pojo.User;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserDao userDao;

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	public List<User> queryAllUser(User user) {
		user.setUserMark(Mark.DB_YES);
		return userDao.queryAllUser(user);
	}

	public boolean insertUser(User user) {
		if (user != null && user.getUserAccount() != null && user.getUserPassword() != null) {
			user.setUserMark(Mark.DB_YES);
			return userDao.insertUser(user);
		}
		return false;
	}

	@Override
	public User findUserByName(String username) {
		return findUserByName(username);
	}

	public boolean updateUser(User user) {
		if (user != null && user.getUserId() != null) {
			User u = new User();
			u.setUserId(user.getUserId());
			List<User> userinfo = userDao.findUserById(u.getUserId());
			if (userinfo != null && userinfo.size() == 1) {
				User puser = userinfo.get(0);
				if (puser != null) {
					puser.setUserId(user.getUserId());
					puser.setUserName(user.getUserName());
					puser.setUserAccount(user.getUserAccount());
					puser.setUserPassword(user.getUserPassword());
					puser.setUserUserId(user.getUserUserId());
					puser.setRoleId(user.getRoleId());
					puser.setDeptId(user.getDeptId());
					return userDao.updateUser(puser);
				}
			}
		}
		return false;
	}

	@Override
	public User findUserByAccount(String Account) {
		return userDao.findUserByAccount(Account);
	}

	@Override
	public List<User> findUserById(Integer userId) {
		return userDao.findUserById(userId);
	}

	@Override
	public boolean upPassword(User user) {
		return userDao.upPassword(user);
	}

	public boolean delUser(User user) {
		if (user != null && user.getUserId() != null) {
			User us = new User();
			us.setUserId(user.getUserId());
			List<User> userinfo = userDao.findUserById(us.getUserId());
			if (userinfo != null && userinfo.size() == 1) {
				User users = userinfo.get(0);
				users.setUserMark(Mark.DB_NO);
				return userDao.delUser(users);
			}
		}
		return false;
	}
}

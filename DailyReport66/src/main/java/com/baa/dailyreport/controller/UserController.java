package com.baa.dailyreport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baa.dailyreport.bean.User;
import com.baa.dailyreport.dao.UserDao;
import com.baa.dailyreport.dao.impl.UserLoginImpl;


@Controller
public class UserController {

	@Autowired
	private UserLoginImpl userLoginImpl=new UserLoginImpl();

	@Autowired
	private UserDao userDao;

	/**
	 * 登录用户
	 *
	 * @param email
	 * @param passWord
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="logined", method = RequestMethod.POST)
	public String loginSuccess(HttpServletRequest request, String userId,String userPassword, HttpSession httpSession) throws Exception {
		// 登录用户，并将登录后的状态码返回，如果是0用户不存在，如果是1那么密码错误，如果是2那么密码正确
		int result = userLoginImpl.login(userId,userPassword);
		// 查找这个用户
		User user = userDao.findUserById(userId);
		if (result == 2) {
			// 如果是2，那么登录成功，返回index
			// 设置session
			httpSession.setAttribute("userName", user.getUsername());
			httpSession.setAttribute("userId",userId);
			List<User> list = userDao.queryAll();
			request.setAttribute("list", list);
			return "list";
		} else if (result == 1) {
			// 如果是1，那么密码错误，返回login
			return "index";
		} else {
			return "index";
		}
	}

	@RequestMapping(value = "login")
	public String logined() {
		return "index";

	}
}

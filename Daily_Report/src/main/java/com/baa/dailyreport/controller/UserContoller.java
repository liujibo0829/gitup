package com.baa.dailyreport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.baa.dailyreport.dao.Mark;
import com.baa.dailyreport.dao.RoleMenuDao;
import com.baa.dailyreport.dao.impl.DeptDaoImpl;
import com.baa.dailyreport.dao.impl.RoleDaoImpl;
import com.baa.dailyreport.dao.impl.UserDaoImpl;
import com.baa.dailyreport.pojo.Dept;
import com.baa.dailyreport.pojo.Role;
import com.baa.dailyreport.pojo.RoleMenu;
import com.baa.dailyreport.pojo.User;

import net.sf.json.JSONArray;

@Controller
public class UserContoller {

	@Autowired
	private UserDaoImpl userDaoImpl;
	@Autowired
	private RoleMenuDao roleMenuDao;

	@Autowired
	private DeptDaoImpl deptDaoImpl;

	@Autowired
	public RoleDaoImpl roleDaoImpl;

	@RequestMapping(value = "index")
	public String index() {
		return "index";

	}

	@RequestMapping(value = "login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "logined", method = RequestMethod.POST)
	public String logined(HttpServletRequest request, Model model, User user, HttpSession session) throws Exception {
		User users = userDaoImpl.login(user);
		if (users != null) {
			List<RoleMenu> roleMenu = roleMenuDao.findMenu(users.getRoleId());
			session.setAttribute(Mark.LOGIN_SESSION_USER, users);
			session.setAttribute("userName", users.getUserName());
			session.setAttribute("userId", users.getUserId());
			session.setAttribute("password", users.getUserPassword());
			model.addAttribute("users", users);
			session.setAttribute("MenuInfo", roleMenu);
			return "redirect:index";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "upU", method = RequestMethod.GET)
	public String upU(HttpServletRequest request) throws Exception {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		Dept dept = new Dept();
		dept.setDeptMark(Mark.DB_YES);
		List<Dept> deptAll = deptDaoImpl.queryDept(dept);
		request.setAttribute("deptAll", deptAll);

		Role role = new Role();
		role.setRoleMark(Mark.DB_YES);
		List<Role> roleAll = roleDaoImpl.queryRole(role);
		request.setAttribute("roleAll", roleAll);

		User user = new User();
		List<User> userlist = userDaoImpl.queryAllUser(user);
		request.setAttribute("userUser", userlist);
		List<User> users = userDaoImpl.findUserById(userId);
		User u = users.get(0);

		request.setAttribute("user", u);
		return "userup";
	}

	@RequestMapping(value = "registry")
	public String registry(HttpServletRequest request) {
		Dept dept = new Dept();
		dept.setDeptMark(Mark.DB_YES);
		List<Dept> deptAll = deptDaoImpl.queryDept(dept);
		request.setAttribute("deptAll", deptAll);

		Role role = new Role();
		role.setRoleMark(Mark.DB_YES);
		List<Role> roleAll = roleDaoImpl.queryRole(role);
		request.setAttribute("roleAll", roleAll);

		User users = new User();
		List<User> userin = userDaoImpl.queryAllUser(users);
		request.setAttribute("userinfo", userin);
		return "user_add";
	}

	/**
	 * 注册用户
	 * 
	 * @param request
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, User user) throws Exception {
		boolean result = userDaoImpl.insertUser(user);
		request.setAttribute("bln", result);
		return "redirect:AllUser";
	}

	@RequestMapping(value = "AllUser")
	public String queryAllUser(HttpServletRequest request, User user) {

		String userName = user.getUserName();
		request.setAttribute("userNameinfo", userName);

		String userAccount = user.getUserAccount();
		request.setAttribute("userAccount", userAccount);

		Dept dept = new Dept();
		dept.setDeptMark(Mark.DB_YES);
		List<Dept> deptAll = deptDaoImpl.queryDept(dept);
		request.setAttribute("deptAll", deptAll);

		Role role = new Role();
		role.setRoleMark(Mark.DB_YES);
		List<Role> roleAll = roleDaoImpl.queryRole(role);
		request.setAttribute("roleAll", roleAll);

		User users = new User();
		List<User> userin = userDaoImpl.queryAllUser(users);
		JSONArray array = JSONArray.fromObject(userin);
		String userinfo = array.toString();
		request.setAttribute("userinfo", userinfo);

		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (userId != 4) {
			user.setUserUserId(userId);
		}
		List<User> userlist = userDaoImpl.queryAllUser(user);
		request.setAttribute("userlist", userlist);
		return "user_list";
	}

	@RequestMapping(value = "upUser", method = RequestMethod.GET)
	public String upUser(HttpServletRequest request, @RequestParam(value = "userId", required = true) Integer userId)
			throws Exception {
		Dept dept = new Dept();
		dept.setDeptMark(Mark.DB_YES);
		List<Dept> deptAll = deptDaoImpl.queryDept(dept);
		request.setAttribute("deptAll", deptAll);

		Role role = new Role();
		role.setRoleMark(Mark.DB_YES);
		List<Role> roleAll = roleDaoImpl.queryRole(role);
		request.setAttribute("roleAll", roleAll);

		User user = new User();
		List<User> userlist = userDaoImpl.queryAllUser(user);
		request.setAttribute("userUser", userlist);
		List<User> users = userDaoImpl.findUserById(userId);
		User u = users.get(0);

		request.setAttribute("user", u);
		return "user_update";
	}

	@RequestMapping(value = "updateUser", method = RequestMethod.POST)
	public String modifyUser(User user) {
		userDaoImpl.updateUser(user);
		return "redirect:AllUser";
	}

	@RequestMapping(value = "loginout")
	public String loginout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@RequestMapping(value = "edPass")
	public String edPass(HttpServletRequest request) {
		return "uppassword";

	}

	@RequestMapping(value = "uppass", method = RequestMethod.POST)
	public String upPass(User user) {
		userDaoImpl.upPassword(user);
		return "redirect:loginout";
	}

	@RequestMapping(value = "upUser", method = RequestMethod.POST)
	public String moUser(User user) {
		userDaoImpl.updateUser(user);
		return "redirect:upU";
	}
	
	@RequestMapping(value = "delUser")
	public String delUser(User user) {
		return "redirect:AllUser";
	}
}

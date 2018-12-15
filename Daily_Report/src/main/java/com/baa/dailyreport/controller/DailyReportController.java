package com.baa.dailyreport.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.baa.dailyreport.dao.impl.DailyReportDaoImpl;
import com.baa.dailyreport.dao.impl.UserDaoImpl;
import com.baa.dailyreport.pojo.DailyReport;
import com.baa.dailyreport.pojo.User;

@Controller
public class DailyReportController {

	@Autowired
	private DailyReportDaoImpl dailyReportDaoImpl;
	@Autowired
	private UserDaoImpl userDaoImpl;

	@RequestMapping(value = "list")
	public String queryAll(HttpServletRequest request, DailyReport dailyReport) throws Exception {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		String createDate = request.getParameter("createDate");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String gettime = sdf.format(date);
		if (createDate != null) {
			dailyReport.setCreateDate(createDate);
		}
		dailyReport.setUserId(userId);
		List<DailyReport> daily = dailyReportDaoImpl.findDailyReport(dailyReport);
		for (DailyReport dailyReport2 : daily) {
			String create = dailyReport2.getCreateDate().substring(0, 10);
			if (create.equals(gettime)) {
				Integer mark = 1;
				request.setAttribute("mark", mark);
			}
		}
		request.setAttribute("daily", daily);
		return "dailyreport_list";
	}

	@RequestMapping(value = "insert")
	public String write() {
		return "dailyreport_add";
	}

	@RequestMapping(value = "mainlist")
	public String main() {
		return "main";
	}

	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writeDailyReport(DailyReport dailyReport, HttpServletRequest request) {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		dailyReport.setUserId(userId);
		boolean result = dailyReportDaoImpl.writeDailyReport(dailyReport);
		if (result) {
			request.setAttribute("bln", result);
			return "redirect:list";
		} else {
			request.setAttribute("bln", result);
			return "insert";
		}
	}

	@RequestMapping(value = "delDaily")
	public String delete(HttpServletRequest request, DailyReport dailyReport,
			@RequestParam(value = "createDate", required = true) String createDate) {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		dailyReport.setCreateDate(createDate);
		dailyReport.setUserId(userId);
		Integer i = dailyReportDaoImpl.delDailyReport(dailyReport);
		if (i > 0) {
			boolean bln = true;
			request.setAttribute("bln", bln);
		} else {
			boolean bln = false;
			request.setAttribute("bln", bln);
		}
		return "redirect:list";
	}

	@RequestMapping(value = "dailyreport_main")
	public String menuMain(HttpServletRequest request) {
		return "dailyreport_main";
	}

	@RequestMapping(value = "dailyreport_left")
	public String menuLeft(HttpServletRequest request) {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		User user = new User();
		if (userId != 4) {
			user.setUserUserId(userId);
		}
		List<User> userlist = userDaoImpl.queryAllUser(user);
		request.setAttribute("userlist", userlist);
		return "dailyreport_left";
	}

	@RequestMapping(value = "dailyreport_right")
	public String dailyreport() {
		return "dailyreport_right";
	}

	@RequestMapping(value = "show")
	public String userListDail(HttpServletRequest request,
			@RequestParam(value = "userId", required = true) Integer userId) {
		DailyReport dailyReport = new DailyReport();
		dailyReport.setUserId(userId);
		List<DailyReport> list = dailyReportDaoImpl.findDailyReport(dailyReport);
		request.setAttribute("userlist", list);
		return "dailyreport_manage";
	}

	@RequestMapping(value = "reader", method = RequestMethod.POST)
	public String readDailyReport(HttpServletRequest request, DailyReport dailyReport) {
		dailyReport.setReader((String) request.getSession().getAttribute("userName"));
		boolean bln = dailyReportDaoImpl.readDailyReport(dailyReport);
		System.out.println(bln);
		request.setAttribute("bln", bln);
		return "redirect:show?userId=" + dailyReport.getUserId();
	}
}

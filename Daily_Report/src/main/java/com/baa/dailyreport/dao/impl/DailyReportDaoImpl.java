package com.baa.dailyreport.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baa.dailyreport.dao.DailyReportDao;
import com.baa.dailyreport.dao.Mark;
import com.baa.dailyreport.pojo.DailyReport;
import com.baa.dailyreport.pojo.User;

@Service
public class DailyReportDaoImpl implements DailyReportDao {

	@Autowired
	private DailyReportDao dailyReportDao;

	@Override
	public List<DailyReport> queryAll() {
		return dailyReportDao.queryAll();
	}

	public boolean writeDailyReport(DailyReport dailyReport) {
		String dailyReportState = "未阅读";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String createDate = df.format(date);
		dailyReport.setCreateDate(createDate);
		dailyReport.setDailyReportMark(Mark.DB_YES);
		dailyReport.setDailyReportState(dailyReportState);
		return dailyReportDao.writeDailyReport(dailyReport);
	}

	public boolean readDailyReport(DailyReport dailyReport) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String createDate = df.format(date);
		dailyReport.setReaderDate(createDate);
		String state="已阅读";
		dailyReport.setDailyReportState(state);
		return dailyReportDao.readDailyReport(dailyReport);
	}

	@Override
	public DailyReport findDailyReportByDailyReportId(Integer dailyReportId) {
		return dailyReportDao.findDailyReportByDailyReportId(dailyReportId);
	}

	@Override
	public List<User> findSubordinates(Integer UserId) {
		return dailyReportDao.findSubordinates(UserId);
	}

	@Override
	public List<DailyReport> findDailyReport(DailyReport dailyReport) {
		return dailyReportDao.findDailyReport(dailyReport);
	}

	public Integer delDailyReport(DailyReport dailyReport) {
		dailyReport.setDailyReportMark(Mark.DB_NO);
		return dailyReportDao.delDailyReport(dailyReport);
	}

}

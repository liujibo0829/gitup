package com.baa.dailyreport.dao;

import java.util.List;

import com.baa.dailyreport.pojo.DailyReport;
import com.baa.dailyreport.pojo.User;

public interface DailyReportDao {

	public List<DailyReport> queryAll();

	public boolean writeDailyReport(DailyReport dailyReport);

	public boolean readDailyReport(DailyReport dailyReport);

	public DailyReport findDailyReportByDailyReportId(Integer dailyReportId);

	public List<User> findSubordinates(Integer UserId);

	public List<DailyReport> findDailyReport(DailyReport dailyReport);

	public  Integer delDailyReport(DailyReport dailyReport);

}

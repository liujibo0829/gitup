package com.baa.dailyreport.pojo;

import java.io.Serializable;

public class DailyReport implements Serializable {

	private static final long serialVersionUID = 4111742159049900711L;
	private Integer dailyReportId;
	private Integer userId;
	private String dailyReport;
	private String createDate;
	private String dailyReportState;
	private String reader;
	private String readerDate;
	private String dailyReportMark;
	private User user;

	public Integer getDailyReportId() {
		return dailyReportId;
	}

	public void setDailyReportId(Integer dailyReportId) {
		this.dailyReportId = dailyReportId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDailyReport() {
		return dailyReport;
	}

	public void setDailyReport(String dailyReport) {
		this.dailyReport = dailyReport;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getDailyReportState() {
		return dailyReportState;
	}

	public void setDailyReportState(String dailyReportState) {
		this.dailyReportState = dailyReportState;
	}

	public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}

	public String getReaderDate() {
		return readerDate;
	}

	public void setReaderDate(String readerDate) {
		this.readerDate = readerDate;
	}

	 

	public String getDailyReportMark() {
		return dailyReportMark;
	}

	public void setDailyReportMark(String dailyReportMark) {
		this.dailyReportMark = dailyReportMark;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

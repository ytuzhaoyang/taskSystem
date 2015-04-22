package com.zy.po;

public class TaskBean {

	private int taskId;
	private int userId;
	private String dateTime;
	private String taskContent;
	private int interestTimes;
	private int riticismTimes;
	private int taskState;
	public TaskBean() {
		super();
	}
	public TaskBean(int userId, String dateTime,
			String taskContent, int interestTimes, int riticismTimes,
			int taskState) {
		super();
		this.userId = userId;
		this.dateTime = dateTime;
		this.taskContent = taskContent;
		this.interestTimes = interestTimes;
		this.riticismTimes = riticismTimes;
		this.taskState = taskState;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getTaskContent() {
		return taskContent;
	}
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	public int getInterestTimes() {
		return interestTimes;
	}
	public void setInterestTimes(int interestTimes) {
		this.interestTimes = interestTimes;
	}
	public int getRiticismTimes() {
		return riticismTimes;
	}
	public void setRiticismTimes(int riticismTimes) {
		this.riticismTimes = riticismTimes;
	}
	public int getTaskState() {
		return taskState;
	}
	public void setTaskState(int taskState) {
		this.taskState = taskState;
	}
	
	
}

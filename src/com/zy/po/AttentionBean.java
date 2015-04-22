package com.zy.po;

public class AttentionBean {

	private int attentionId;
	private int taskId;
	private int userId;
	private String dateTime;
	private int attentionState;
	public AttentionBean() {
		super();
	}
	public AttentionBean(int taskId, int userId,
			String dateTime, int attentionState) {
		super();
		this.taskId = taskId;
		this.userId = userId;
		this.dateTime = dateTime;
		this.attentionState = attentionState;
	}
	public int getAttentionId() {
		return attentionId;
	}
	public void setAttentionId(int attentionId) {
		this.attentionId = attentionId;
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
	public int getAttentionState() {
		return attentionState;
	}
	public void setAttentionState(int attentionState) {
		this.attentionState = attentionState;
	}
	
	
}

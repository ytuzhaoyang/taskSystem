package com.zy.po;

public class MessageBean {

	private int messageId;
	private int taskId;
	private int userId;
	private String dateTime;
	private String messageContent;
	private String messageState;
	public MessageBean() {
		super();
	}
	public MessageBean(int taskId, int userId, String dateTime,
			String messageContent, String messageState) {
		super();
		this.taskId = taskId;
		this.userId = userId;
		this.dateTime = dateTime;
		this.messageContent = messageContent;
		this.messageState = messageState;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
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
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getMessageState() {
		return messageState;
	}
	public void setMessageState(String messageState) {
		this.messageState = messageState;
	}
	
	
}

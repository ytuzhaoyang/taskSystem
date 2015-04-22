package com.zy.po;

public class UserBean {

	private int userId;
	private String userName;
	private String userPwd;
	private String userPhone;
	private String userSex;
	private String userSchool;
	private String userPhoto;
	private int userState;
	public UserBean() {
		super();
	}
	public UserBean(String userName, String userPwd,
			String userPhone, String userSex, String userSchool,
			String userPhoto, int userState) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.userPhone = userPhone;
		this.userSex = userSex;
		this.userSchool = userSchool;
		this.userPhoto = userPhoto;
		this.userState = userState;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserSchool() {
		return userSchool;
	}
	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}
	
	
}

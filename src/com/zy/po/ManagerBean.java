package com.zy.po;

public class ManagerBean {

	private int managerId;
	private String managerName;
	private String managerPhone;
	private String managerPwd;
	private int managerState;
	
	public ManagerBean() {
		super();
	}
	
	public ManagerBean(String managerName, String managerPhone,
			String managerPwd, int managerState) {
		super();
		this.managerName = managerName;
		this.managerPhone = managerPhone;
		this.managerPwd = managerPwd;
		this.managerState = managerState;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	public int getManagerState() {
		return managerState;
	}

	public void setManagerState(int managerState) {
		this.managerState = managerState;
	}
	
	
}

package com.hp.onlinexamqfnu.po;

public class Teacher {
	public String name;
	public int id;
	public String pwd;
	public String deptName;
	

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}

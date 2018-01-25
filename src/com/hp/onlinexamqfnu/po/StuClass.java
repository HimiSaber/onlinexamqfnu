package com.hp.onlinexamqfnu.po;



/**
 * 学生班级
 * 
 * @author HP
 *
 */
public class StuClass {
	private int id;
	private String name;
	private String deptName;// 对象改为基本类型

	public StuClass() {

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

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}

package com.hp.onlinexamqfnu.po;

import java.util.Date;

public class Test {
	private int id;
	private String name;
	private int courseId;
	private int depId;//待定
	private Date endDate;
	private String quetions;
	private int teacherId;
	private String classIds;
	private int testTime;
	//考虑设置多个题型
	private String scores;
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
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getQuetions() {
		return quetions;
	}
	public void setQuetions(String quetions) {
		this.quetions = quetions;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getClassIds() {
		return classIds;
	}
	public void setClassIds(String classid) {
		this.classIds = classid;
	}
	public int getTestTime() {
		return testTime;
	}
	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}
	public String getScores() {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
}

package com.hp.onlinexamqfnu.po;

public class Paper {
	int id;
	int testId;
	int courseId;	
	String time;
	double score;
	String wrongQueId;
	String wrongAns;
	int studentId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getWrongQueId() {
		return wrongQueId;
	}
	public void setWrongQueId(String wrongQueId) {
		this.wrongQueId = wrongQueId;
	}
	public String getWrongAns() {
		return wrongAns;
	}
	public void setWrongAns(String wrongAns) {
		this.wrongAns = wrongAns;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

}

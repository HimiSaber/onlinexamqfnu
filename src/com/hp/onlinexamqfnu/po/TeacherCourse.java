package com.hp.onlinexamqfnu.po;

/**
 * 教师课程关联
 * @author Administrator
 *
 */
public class TeacherCourse {
	private int id;
	private int teaId;//改
	private int courseId;//改
	private int classId;//改

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeaId() {
		return teaId;
	}
	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
}

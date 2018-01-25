package com.hp.onlinexamqfnu.service.admin;

import java.util.List;

import com.hp.onlinexamqfnu.dao.admin.CourseDao;
import com.hp.onlinexamqfnu.dao.admin.ICourseDao;
import com.hp.onlinexamqfnu.po.Course;
import com.hp.onlinexamqfnu.po.TeacherCourse;
import com.hp.onlinexamqfnu.vo.TeacherCourseView;

public class CourseService implements ICourseService {
	private ICourseDao cd=new CourseDao();

	@Override
	public List<TeacherCourseView> findAll() {
		// TODO Auto-generated method stub
		return cd.findAllTeaCourInfo();
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return cd.findTeacherCourseById(id);
	}

	@Override
	public Course findCourseById(int id) {
		// TODO Auto-generated method stub
		return cd.findCourseById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return cd.findAllCourses();
	}

	@Override
	public List<Course> findAllCourses(String name) {
		// TODO Auto-generated method stub
		return cd.findAllCoursesByName(name);
	}

	@Override
	public void modifyTeacherCourse(TeacherCourse tc) {
		cd.updateTeacherCourse(tc);
		
	}

	@Override
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTeacherCourse(int tcId) {
		// TODO Auto-generated method stub
		cd.deleteTourse(tcId);
	}

	@Override
	public void addCourse(String courseName) {
		// TODO Auto-generated method stub
		cd.addCourse(courseName);
		
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		cd.updateCourse(course);
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		// TODO Auto-generated method stub
		cd.addTeacherCourse(tc);
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		return cd.findCoursesByTeacherId(teaId);
	}




}

package com.hp.onlinexamqfnu.dao.admin;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexamqfnu.po.Course;
import com.hp.onlinexamqfnu.po.DBUtil;
import com.hp.onlinexamqfnu.po.StuClass;
import com.hp.onlinexamqfnu.po.TeacherCourse;
import com.hp.onlinexamqfnu.vo.TeacherCourseView;


public class CourseDao implements ICourseDao{
	private DBUtil db=new DBUtil();
	@Override
	public List<TeacherCourseView> findAllTeaCourInfo() {
		// TODO Auto-generated method stub
		String sql="select tc.id tcId,tc.teaId teacherId,tc.courseId courseId,tc.classId stuclassId ,t.name teacherName,c.name courseName,sc.name stuclassName from teachercourse tc,teacher t,course c,stuclass sc where tc.teaId=t.id and tc.courseId=c.id AND tc.classId=sc.id;";
		List tc= new ArrayList();
		try {
			tc=db.getQueryList(sql,new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tc;
		}
	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		String sql = "select * from teachercourse where id = ?";
		try {
			return (TeacherCourse)db.getObject(TeacherCourse.class,sql,new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addCourse(String name) {
		// TODO Auto-generated method stub
		String sql="insert into course (name) values(?)";
		try {
			db.execute(sql,new Object[] {name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCourse(Course course) {
		String sql = "update course set name = ? where id = ?";
		try {
			db.execute(sql,new Object[] {course.getName(),course.getId()});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Course findCourseById(int id) {
		String sql = "select * from course where id = ?";
		try {
			return (Course)db.getObject(Course.class,sql,new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		String sql="insert into teachercourse (teaId,courseId,classId) values(?,?,?)";
		try {
			db.execute(sql,new Object[] {tc.getTeaId(),tc.getCourseId(),tc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		String sql = "select * from teachercourse where id = ?";
		try {
			return (TeacherCourseView)db.getObject(TeacherCourseView.class,sql,new Object[] {id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Course> findAllCourses() {
		String sql="select * from course";
		List courseList=new ArrayList();
		try {
			courseList=db.getQueryList(Course.class,sql,new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			courseList=new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		String sql="select * from course where name=?";
		List courseList=new ArrayList();
		try {
			courseList=db.getQueryList(Course.class,sql,new Object[] {name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			courseList=new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		String sql = "update teachercourse set teaId= ?,classId=? where id = ?";
		try {
			db.execute(sql,new Object[] {tc.getTeaId(),tc.getClassId(),tc.getId()});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTourse(int tcId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		String sql="SELECT * from course WHERE id  in (select DISTINCT courseId from teachercourse where teaId = ?)";
		List cList=new ArrayList();
		try {
			cList=db.getQueryList(Course.class,sql,new Object[] {teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cList;
	}
	
	
}
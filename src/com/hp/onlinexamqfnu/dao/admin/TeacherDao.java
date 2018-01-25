package com.hp.onlinexamqfnu.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.DBUtil;
import com.hp.onlinexamqfnu.po.Teacher;

public class TeacherDao implements ITeacherDao {
	private DBUtil db=new DBUtil();

	@Override
	public List<Teacher> findAllTeacherInfo() {
		// TODO Auto-generated method stub
		String sql="select * from teacher";
		List teacherList=new ArrayList();
		try {
			teacherList=db.getQueryList(Teacher.class,sql,new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			teacherList=new ArrayList();
			e.printStackTrace();
		}
		return teacherList;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql="insert into teacher values(?,?,?,?)";
		try {
			db.execute(sql, new Object[] {teacher.getId(),teacher.getName(),teacher.getPwd(),teacher.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldId) {
		String sql = "update teacher set id=?,name=?,pwd=?,deptName =? where id =?";
		try {
			db.execute(sql,new Object[] {teacher.getId(),teacher.getName(),teacher.getPwd(),teacher.getDeptName(),teacher.getId()});
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public Teacher findTeacherInfo(int id) {
		String sql = "Select * from teacher where id = ?";
		try {
			return (Teacher)db.getObject(Teacher.class,sql,new Object[] {id});
		} catch (Exception e) {
			e.printStackTrace();
			return new Teacher();
		}
	}

	@Override
	public List<Teacher> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

}

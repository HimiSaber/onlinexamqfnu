package com.hp.onlinexamqfnu.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.DBUtil;
import com.hp.onlinexamqfnu.po.StuClass;
import com.hp.onlinexamqfnu.po.Student;

public class StudentDao implements IStudentDao {
	private DBUtil db=new DBUtil();
	@Override
	public void addStudent(Student s) {
		String sql="insert into student values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {s.getId(),s.getName(),s.getPwd(),s.getSchool(),s.getDeptName(),s.getSex(),s.getBorn(),s.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		String sql = "Update student set id = ?,name = ?, pwd = ?,school = ?, sex = ?, born = ?, classId =? where id = ?";
		try {
			db.execute(sql,new Object[] {s.getId(),s.getName(),s.getPwd(),s.getSchool(),s.getSex(),s.getBorn(),s.getClassId(),s.getId()});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student findStudentById(int id) {
		String sql= "Select * From student where id = ?";
		try {
			return (Student)db.getObject(Student.class,sql,new Object[] {id});
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> findAll() {
		String sql="select * from student";
		List stuList=new ArrayList();
		try {
			stuList=db.getQueryList(Student.class,sql,new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuList=new ArrayList();
			e.printStackTrace();
		}
		return stuList;
	}

}

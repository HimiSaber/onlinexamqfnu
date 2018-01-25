package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.dao.admin.IStudentDao;
import com.hp.onlinexamqfnu.dao.admin.StudentDao;
import com.hp.onlinexamqfnu.po.StuClass;
import com.hp.onlinexamqfnu.po.Student;

public class StudentService implements IStudentService{
   private IStudentDao sd=new StudentDao();
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		sd.addStudent(s);
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		sd.updateStudent(s);
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return sd.findStudentById(id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return sd.findAll();
	}

	
	

}

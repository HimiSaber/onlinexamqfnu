package com.hp.onlinexamqfnu.dao.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.Student;

public interface IStudentDao {
	
	public void addStudent(Student s);
	
	public void updateStudent(Student s);
	
	public Student findStudentById(int id);
	
	public List<Student> findAll();
}

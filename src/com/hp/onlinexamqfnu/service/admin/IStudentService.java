package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.StuClass;
import com.hp.onlinexamqfnu.po.Student;;

public interface IStudentService { 
	public void addStudent(Student s);
	public void updateStudent(Student s);
	public Student findStudentById(int id);
	public List<Student> findAll();
	
}

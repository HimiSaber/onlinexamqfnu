package com.hp.onlinexamqfnu.dao.admin;


import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.po.Teacher;

public interface ILoginDao {

	public Teacher canLogin(String name, String password);
	
	public Student canLogin(int id, String password);
}

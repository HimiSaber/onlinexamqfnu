package com.hp.onlinexamqfnu.dao.login;

import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.po.Teacher;

public interface ILoginDao {
	public Teacher canLogin(Teacher t);
	public Student canLogin(Student t);

}

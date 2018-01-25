package com.hp.onlinexamqfnu.service.login;

import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.po.Teacher;

public interface ILoginService {
	public Teacher canLogin(Teacher t);
	public Student canLogin(Student t);

}

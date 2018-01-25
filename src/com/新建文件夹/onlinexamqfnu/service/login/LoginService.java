package com.hp.onlinexamqfnu.service.login;

import com.hp.onlinexamqfnu.dao.login.ILoginDao;
import com.hp.onlinexamqfnu.dao.login.LoginDao;
import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.po.Teacher;

public class LoginService implements ILoginService {
private ILoginDao ld = new LoginDao();
	
	@Override
	public Teacher canLogin(Teacher t) {
		// TODO Auto-generated method stub
		return ld.canLogin(t);
	}

	@Override
	public Student canLogin(Student t) {
		// TODO Auto-generated method stub
		return ld.canLogin(t);
	}

}

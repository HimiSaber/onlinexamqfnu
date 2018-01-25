package com.hp.onlinexamqfnu.dao.login;

import com.hp.onlinexamqfnu.po.DBUtil;
import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.po.Teacher;

public class LoginDao implements ILoginDao {

DBUtil db = new DBUtil();
	
	@Override
	public Teacher canLogin(Teacher t) {
		String sql = "select * from teacher where name = ? and pwd = ?";
		Teacher teacher = new Teacher();
		try {
			teacher = (Teacher)db.getObject(Teacher.class, sql, new Object[] {t.getName(),t.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public Student canLogin(Student t) {
		// TODO Auto-generated method stub
		String sql = "select * from student where name = ? and pwd = ?";
		Student student = new Student();
		try {
			student = (Student)db.getObject(Student.class, sql, new Object[] {t.getName(),t.getPwd()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

}

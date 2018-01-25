package com.hp.onlinexamqfnu.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.dao.admin.ITeacherDao;
import com.hp.onlinexamqfnu.dao.admin.TeacherDao;
import com.hp.onlinexamqfnu.po.Teacher;

public class TeacherService implements ITeacherService {
	private ITeacherDao ts=new TeacherDao();

	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return ts.findAllTeacherInfo();
	}

	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		ts.addTeacher(teacher);
		
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldid) {
		// TODO Auto-generated method stub
		ts.updateTeacher(teacher, oldid);
	}

	@Override
	public Teacher findTeacherInfo(int id) {
		// TODO Auto-generated method stub
		return ts.findTeacherInfo(id);
	}

	@Override
	public List<Teacher> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

}

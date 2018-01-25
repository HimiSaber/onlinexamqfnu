package com.hp.onlinexamqfnu.dao.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.Teacher;

public interface ITeacherDao {

	public List<Teacher> findAllTeacherInfo() ;
	public void addTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher,int oldId);
	public Teacher findTeacherInfo(int id) ;
	
	/**
	 * 根据教师的ID号查询其负责的班级
	 * 
	 * @param teacherId
	 *            教师ID号
	 * @return 返回查询的结果集，包括负责的班级的id号和班级名称等
	 */
	public List<Teacher> findClassesByTeacherId(int teacherId);
}

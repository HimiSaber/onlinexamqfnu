package com.hp.onlinexamqfnu.dao.admin;

import java.awt.print.Paper;
import java.util.List;

public interface IPapersDao {
	
	public int save(Paper  paper);
	
	public List getPaperByStudentId(int studentId,int testId);
	
	public List getPaperByStudentId(int studentId);
	
	//所有的班级成绩。
	public List getPaperCompare();
}

package com.hp.onlinexamqfnu.service.teacher;

import java.util.List;

import com.hp.onlinexamqfnu.po.Paper;

public interface IPaperService { 
	
	public int save(Paper paper);
	/**
	 * 学生试题
	 * @return
	 */
	public List getPaperByStudentId(int studentId,int testId);
	
	/**
	 * 学生以往答过的试卷
	 * @return
	 */
	public List getPaperByStudentId(int studentId);
	
	/**
	 * 获得班级评估信息
	 * @return
	 */
	public List getPaperCompare(int teaId);
}

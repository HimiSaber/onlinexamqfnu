package com.hp.onlinexamqfnu.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.Test;

public interface ITestService { 

	/**
	 * 根据试卷信息创建试卷，持久化到数据库
	 * @param t
	 */
	public void createTest(Test t) ;

	/**
	 * 返回试卷信息
	 * 
	 * @param teaId
	 * @return
	 */
	public List<Map<String, Object>> findTestsByTeaId(int teaId) ;

	/**
	 * 根据试卷id和teacherId查询试卷详细信息
	 * @param id 试卷id号
	 * @param teaId 教师id号
	 * @return 结果集，map类型的
	 */
	public Map<String, Object> findTestById(int id, int teaId);
	
	/**
	 * 根据学生id号和试卷编号查询试卷信息
	 * @param studentid
	 * @param testid
	 * @return 返回试卷信息的map
	 */
	public Map<String, Object> findStudentTestsById(int studentid,int testid) ;
	
	/**
	 * 根据学生id号查询即将考试的试卷（test表）
	 * @param id 学生的id号
	 * @param currData 当前的日期时间
	 * @return 返回的是test集合
	 */
	public List<Map<String, Object>> getTestByStudent(int id, String currData);
	
}

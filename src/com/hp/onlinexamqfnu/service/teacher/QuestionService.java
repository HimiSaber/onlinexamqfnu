package com.hp.onlinexamqfnu.service.teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.dao.teacher.IQuestionDao;
import com.hp.onlinexamqfnu.dao.teacher.QuestionDao;
import com.hp.onlinexamqfnu.po.Question;

public class QuestionService implements IQuestionService {
	IQuestionDao qd = new QuestionDao();

	@Override
	public List<Map<String, Object>> findAll(String key, String value) {
		// TODO Auto-generated method stub
		return qd.findAllQuestionInfo(key, value);

	}

	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		qd.addQuestion(q);
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		// TODO Auto-generated method stub
		return qd.findQuestionById(id);

	}

	@Override
	public void updateQuestionInfo(Question q) {
		// TODO Auto-generated method stub
		qd.updateQuestionInfo(q);
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> collectQuestions(int courseId, int num) {
		/*
		 * 根据课程ID查询出符合条件的试题集合
		 * 随机
		 * 如果试题数量足够，取前num个，如果不够，取所有试题
		 */
		List<Map<String,Object>> queList=qd.findQuestionsByCourseId(courseId);
		if(queList==null||queList.size()<1) {
			return new ArrayList();
		}
		Collections.shuffle(queList);
		if(queList.size()>num) 
			return queList.subList(0, num);
		else
			return queList;
		
		
	}

	@Override
	public String testQuestionIds(List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
				if (null == list)
					return "";
				/**
				 * 字符串的拼接尽量用StringBuffer
				 * String是不可变的，例如String s = "a"+"b"; s +="c"
				 */
				StringBuffer sb = new StringBuffer();
				for (int i = 0 ; i <list.size();i++){
					Map<String,Object> questionMap = list.get(i);
					sb.append(questionMap.get("id")+",");
				}
				String ids = sb.toString();
				if (list.size()>0)
					ids= ids.substring(0, ids.length()-1);
				return ids;
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		
		if (null == ids)
				return new ArrayList<Question>();
			else
				return qd.findQuestionByIds(ids);
		

	}

}

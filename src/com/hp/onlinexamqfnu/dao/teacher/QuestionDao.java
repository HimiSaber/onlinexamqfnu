package com.hp.onlinexamqfnu.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexamqfnu.po.DBUtil;
import com.hp.onlinexamqfnu.po.Question;

public class QuestionDao implements IQuestionDao{
DBUtil db=new DBUtil();
	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		String sql="";
		if(key==null) {
			sql="SELECT que.id ,c.name, que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c where que.courseId = c.id";			
		}else {
			sql="SELECT que.id ,c.name, que.queTitle,que.choiceA,que.choiceB,que.choiceC,que.choiceD,que.ans from questions que, course c where que.courseId = c.id and "
					+ key + " like '%" + value + "%'";
		}
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
		queList = db.getQueryList(sql);
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return queList;

	}

	@Override
	public void addQuestion(Question q) {
		// TODO Auto-generated method stub
		String sql="insert into questions (courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans,queExist) values(?,?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql,new Object[] {q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),1});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		String sql = "select * from questions where id = ?";
		Map<String ,Object> q  = null;
		try {
		q = db.getObject(sql,new Object [] {id});
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return q;

	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
				
			String sql = "select * from questions where FIND_IN_SET (id,?)";
			List questionList = new ArrayList();
			try {
				questionList = db.getQueryList(Question.class, sql, new Object[] {ids});
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			if (null == questionList)
				questionList = new ArrayList();
			return questionList;

	}

	@Override
	public void updateQuestionInfo(Question q) {
		String sql="update questions set courseId=?,queType=?,queTitle=?,choiceA=?,choiceB=?,choiceC=?,choiceD=?,ans=?  where id=?";
		try {
			db.execute(sql,new Object[] {q.getCourseId(),q.getQueType(),q.getQueTitle(),q.getChoiceA(),q.getChoiceB(),q.getChoiceC(),q.getChoiceD(),q.getAns(),q.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		String sql = "SELECT * FROM questions where courseId=?" ;
		List map = new ArrayList();
		try {
		map = db.getQueryList(sql,new Object[] {courseId});
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return map;
	}

	@Override
	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		
	}

}

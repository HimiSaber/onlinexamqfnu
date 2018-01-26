package com.hp.onlinexamqfnu.dao.teacher;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexamqfnu.po.DBUtil;
import com.hp.onlinexamqfnu.po.Paper;
import com.hp.onlinexamqfnu.po.ToolUtil;

public class PapersDao implements IPapersDao{
private DBUtil db=new DBUtil();
	@Override
	public int save(Paper p) {
		String sql="insert into papers(testId,courseId,time,score,wrongQueId,wrongAns,studentId,createDate) values(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {p.getTestId(),p.getCourseId(),p.getTime(),p.getScore(),p.getWrongQueId(),p.getWrongAns(),p.getStudentId(),ToolUtil.getCurrentTime()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId) {
		String sql = "select p.time,p.createDate,p.score,c.name courseName,t.name testName from papers as p, course as c, test as t where c.id=p.courseId and t.id = p.testId and studentId = ? order by createDate";
						List papersList = new ArrayList();
						try {
							papersList = db.getQueryList(sql,new Object[] {studentId});
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return papersList;

	}

	@Override
	public List getPaperCompare(int teaId) {
		// TODO Auto-generated method stub
		return null;
	}

}

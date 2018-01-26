package com.hp.onlinexamqfnu.service.teacher;

import java.util.List;

import com.hp.onlinexamqfnu.dao.teacher.IPapersDao;
import com.hp.onlinexamqfnu.dao.teacher.PapersDao;
import com.hp.onlinexamqfnu.po.Paper;

public class PaperService implements IPaperService {
IPapersDao pd=new PapersDao();
	@Override
	public int save(Paper paper) {
		// TODO Auto-generated method stub
		return pd.save(paper);
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return pd.getPaperByStudentId(studentId);
	}

	@Override
	public List getPaperCompare(int teaId) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.hp.onlinexamqfnu.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hp.onlinexamqfnu.po.Paper;
import com.hp.onlinexamqfnu.po.Question;
import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.po.Test;
import com.hp.onlinexamqfnu.service.teacher.IPaperService;
import com.hp.onlinexamqfnu.service.teacher.IQuestionService;
import com.hp.onlinexamqfnu.service.teacher.ITestService;
import com.hp.onlinexamqfnu.service.teacher.PaperService;
import com.hp.onlinexamqfnu.service.teacher.QuestionService;
import com.hp.onlinexamqfnu.service.teacher.TestService;

/**
 * Servlet implementation class StudentTest
 */
@WebServlet("/studentTest")
public class StudentTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ITestService ts=new TestService();
       private IQuestionService qs=new QuestionService();
       private IPaperService ps=new PaperService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testId=request.getParameter("testId");
		HttpSession session=request.getSession();
		Student s=(Student)session.getAttribute("student");
		Map<String,Object> testInfo=ts.findStudentTestsById(s.getId(), Integer.valueOf(testId));
		List<Question> quesList=qs.findQuestionByIds((String)testInfo.get("questions"));
		double scoreperques=Integer.valueOf((String)testInfo.get("scores"))*1.0/quesList.size();
		session.setAttribute("test", testInfo);
		session.setAttribute("quesList", quesList);
		request.setAttribute("scoreperques", scoreperques);
		request.setAttribute("test", testInfo);
		request.setAttribute("quesList", quesList);
		request.getRequestDispatcher("student/exam.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String time=request.getParameter("hidden1");
		HttpSession session=request.getSession();
		List<Question> quesList=(List<Question>)session.getAttribute("quesList");
		StringBuffer wrongIdsSB=new StringBuffer();
		StringBuffer wrongAnsSB=new StringBuffer();
		int wrongNums=0;
		
		for(int i=0;i<quesList.size();i++) {
			Question q=quesList.get(i);		
			String stuAns=request.getParameter("ques_"+quesList.get(i).getId());
			
			/*
			 * 进行比较，如果错误，记录题号
			 */
			if(!q.getAns().toLowerCase().equals(stuAns)) {
				wrongIdsSB.append(q.getId()).append(",");
				wrongAnsSB.append(stuAns).append(",");
				wrongNums++;
			}
		}
		
		/*
		 * 
		 */
		String wrongIds=wrongIdsSB.toString();
		String wrongAns=wrongAnsSB.toString();
		if(wrongIds.endsWith(",")) {
			wrongIds.substring(0,wrongIds.length()-1);
			wrongAns.substring(0,wrongAns.length()-1);
			
		}
	/*	if(wrongAns.endsWith(",")) {
			wrongAns.substring(0,wrongAns.length());
			
		}*/
		
		/*
		 * 算分
		 */
		
		Map<String,Object> t=(Map<String, Object>) session.getAttribute("test");
		double scores=1.0*Integer.valueOf((String) t.get("scores"))/quesList.size()*(quesList.size()-wrongNums);
		Student s=(Student)request.getSession().getAttribute("student");
		
		/*
		 *信息获取完成
		 */
		Paper p=new Paper();
		p.setCourseId((int) t.get("courseId"));
		p.setScore(scores);
		p.setStudentId(s.getId());
		p.setTestId((int) t.get("id"));
		p.setTime(time);
		p.setWrongQueId(wrongIds);
		p.setWrongAns(wrongAns);
		/*
		 * 封装之后
		 */
		ps.save(p);		
		
		request.getRequestDispatcher("student/index.jsp").forward(request, response);
	}

}

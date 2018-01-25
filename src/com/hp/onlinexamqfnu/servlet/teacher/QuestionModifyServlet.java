package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Question;
import com.hp.onlinexamqfnu.service.admin.CourseService;
import com.hp.onlinexamqfnu.service.admin.ICourseService;
import com.hp.onlinexamqfnu.service.teacher.IQuestionService;
import com.hp.onlinexamqfnu.service.teacher.QuestionService;

/**
 * Servlet implementation class QuestionModifyServlet
 */
@WebServlet("/QuestionModifyServlet")
public class QuestionModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService cs=new CourseService();
	private IQuestionService qs=new QuestionService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.valueOf(request.getParameter("id"));
		Map<String, Object> questionMap=qs.findQuestionById(id);
		List course=cs.findAllCourses();
		request.setAttribute("questionMap", questionMap);
		request.setAttribute("courseList", course);
		request.getRequestDispatcher("/teacher/quesmodify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.valueOf(request.getParameter("id"));
		String courseId=request.getParameter("courseId");
		String queType=request.getParameter("queType");
		String queTitle=request.getParameter("queTitle");
		String choiceA=request.getParameter("choiceA");
		String choiceB=request.getParameter("choiceB");
		String choiceC=request.getParameter("choiceC");
		String choiceD=request.getParameter("choiceD");
		String ans=request.getParameter("ans");
		
		Question q=new Question();
		q.setId(id);
		q.setCourseId(Integer.valueOf(courseId));
		q.setQueType(Integer.valueOf(queType));
		q.setQueTitle(queTitle);
		q.setChoiceA(choiceA);
		q.setChoiceB(choiceB);
		q.setChoiceC(choiceC);
		q.setChoiceD(choiceD);
		q.setAns(ans);
		
		qs.updateQuestionInfo(q);
		request.getRequestDispatcher("/QuestionQueryServlet").forward(request, response);
	}

}

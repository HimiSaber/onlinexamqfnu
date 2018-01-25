package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hp.onlinexamqfnu.po.Course;
import com.hp.onlinexamqfnu.po.Test;
import com.hp.onlinexamqfnu.service.admin.CourseService;
import com.hp.onlinexamqfnu.service.admin.ICourseService;
import com.hp.onlinexamqfnu.service.admin.IStuClassService;
import com.hp.onlinexamqfnu.service.admin.StuClassService;
import com.hp.onlinexamqfnu.service.teacher.IQuestionService;
import com.hp.onlinexamqfnu.service.teacher.ITestService;
import com.hp.onlinexamqfnu.service.teacher.QuestionService;
import com.hp.onlinexamqfnu.service.teacher.TestService;
import com.hp.onlinexamqfnu.util.ToolUtil;

/**
 * Servlet implementation class TestAddServlet
 */
@WebServlet("/TestAddServlet")
public class TestAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService cs=new CourseService();
	private IStuClassService scs=new StuClassService();
	private ITestService ts=new TestService();
	private IQuestionService qs=new QuestionService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//session.getAttribute("teacher.name");
		int teacherId=(int) session.getAttribute("teacher.id");
		List course=cs.findCoursesByTeacherId(teacherId);
		List stuClass=scs.findStuClassesByTeacherId(teacherId);
		request.setAttribute("courseList", course);
		request.setAttribute("classesList", stuClass);
		request.getRequestDispatcher("/teacher/testadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 选题。根据课程查询试题，并随机出题
		 */
		HttpSession session = request.getSession();
		
		int teacherId=(int) session.getAttribute("teacher.id");
		int questions=Integer.valueOf(request.getParameter("sinnum"));
		int courseId=Integer.valueOf(request.getParameter("courseid"));
		String testname=request.getParameter("testname");
		String testtime=request.getParameter("testtime");
		String[] classid=request.getParameterValues("classCheck");
		String scores=request.getParameter("sinscores");
		
		/*
		 * String转换为Date
		 */
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		try{
		  d=df.parse(request.getParameter("enddate"));
		}
		catch(Exception e){
		} 
		
		/*
		 * 根据id查询课程对象
		 * 根据班级id的数组查询名称
		 */
		Course c=cs.findCourseById(courseId);
		String classIds=ToolUtil.arraytoString(classid);
		String classname=scs.findClassNamesByIds(classIds);
		
		
		
		List<Map<String,Object>> questionList=qs.collectQuestions(courseId, questions);
		String queList=qs.testQuestionIds(questionList);
		/*
		 * 试卷信息的封装
		 */
		
		Test t=new Test();
		t.setClassIds(classIds);
		t.setCourseId(courseId);
		t.setEndDate(d);
		t.setScores(scores);
		t.setName(testname);
		t.setTeacherId(teacherId);
		t.setTestTime(Integer.valueOf(testtime));
		t.setQuetions(queList);
	
		session.setAttribute("test", t);
		//ts.createTest(t);
		request.setAttribute("test", t);
		request.setAttribute("c", c);
		request.setAttribute("classNames", classname);
		request.setAttribute("quesList", questionList);
		/*
		 * 页面跳转有两种方式
		 *若在servlet中有网页面传递的数据，例如request.setAttribute()则需要用getRequestDispatcher
		 *若没有则sendDirect一样
		 */
	
		request.getRequestDispatcher("/teacher/test.jsp").forward(request, response);
	}

}

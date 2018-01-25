package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hp.onlinexamqfnu.po.Test;
import com.hp.onlinexamqfnu.service.admin.IStuClassService;
import com.hp.onlinexamqfnu.service.admin.StuClassService;
import com.hp.onlinexamqfnu.service.teacher.ITestService;
import com.hp.onlinexamqfnu.service.teacher.TestService;

/**
 * Servlet implementation class TestQueryService
 */
@WebServlet("/TestQueryServlet")
public class TestQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ITestService ts=new TestService();
       private IStuClassService scs=new StuClassService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session = request.getSession();
		int teacherId=(int) session.getAttribute("teacher.id");
		Test test=(Test)session.getAttribute("test");
		
	
		List testList=ts.findTestsByTeaId(teacherId);
		
		
		request.setAttribute("testsList", testList);
		request.getRequestDispatcher("/teacher/tmain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

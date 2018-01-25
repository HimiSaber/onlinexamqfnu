package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.po.Test;
import com.hp.onlinexamqfnu.service.teacher.ITestService;
import com.hp.onlinexamqfnu.service.teacher.TestService;

/**
 * Servlet implementation class TestCreateServlet
 */
@WebServlet("/TestCreateServlet")
public class TestCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITestService ts=new TestService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		int tid=(int) session.getAttribute("teacher.id");
		Test test=(Test)session.getAttribute("test");
		
		ts.createTest(test);
		/*
		 * 页面跳转有两种方式
		 *若在servlet中有网页面传递的数据，例如request.setAttribute()则需要用getRequestDispatcher
		 *若没有则sendDirect一样
		 */
		request.getRequestDispatcher("TestQueryServlet").forward(request, response);
	}

}

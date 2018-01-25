package com.hp.onlinexamqfnu.servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.service.login.ILoginService;
import com.hp.onlinexamqfnu.service.login.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ILoginService ls=new LoginService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		String role=request.getParameter("role");
		
		if("admin".equals(role)) {
			if("admin".equals(username)&&"123".equals(pwd)) {
				response.sendRedirect("manager/mindex.jsp");
				
			}
			
		}else if ("teacher".equals(role)) {
			Teacher t=new Teacher();
			t.setName(username);
			t.setPwd(pwd);
			t=ls.canLogin(t);
			if(t!=null) {
				/*
				 * 多次请求响应中间要保存一些共用信息
				 */
				
				HttpSession session = request.getSession();
				session.setAttribute("teacher.name", t.getName());
				session.setAttribute("teacher.id", t.getId());
				response.sendRedirect("teacher/tindex.jsp");
			}
		}else if("student".equals(role)) {
				Student s=new Student();
				s.setName(username);
				s.setPwd(pwd);
				
				s=ls.canLogin(s);
				if(s!=null) {
					/*
					 * 多次请求响应中间要保存一些共用信息
					 */
					
					HttpSession session = request.getSession();
					session.setAttribute("studentname", s.getName());
					session.setAttribute("studentid", s.getId());
					response.sendRedirect("student/sindex.jsp");
				
			}
			
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

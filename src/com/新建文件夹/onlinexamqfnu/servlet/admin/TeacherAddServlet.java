package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Department;
import com.hp.onlinexamqfnu.po.StuClass;
import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.service.admin.ITeacherService;
import com.hp.onlinexamqfnu.service.admin.TeacherService;


/**
 * Servlet implementation class TeacherAddServlet
 */
@WebServlet("/TeacherAddServlet")
public class TeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITeacherService ts=new TeacherService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("deptList",Department.values() );
		request.getRequestDispatcher("/manager/teacheradd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Num =request.getParameter("num");
		String Name=request.getParameter("username");
		String pwd=request.getParameter("password");
		String  dep=request.getParameter("dep");
		
		Teacher tc=new Teacher();
		tc.setId(Integer.valueOf(Num));
		tc.setName(Name);
		tc.setDeptName(dep);
		tc.setPwd(pwd);
		
		ts.addTeacher(tc);
		
		request.getRequestDispatcher("/TeacherQueryServlet").forward(request, response);
	}

}

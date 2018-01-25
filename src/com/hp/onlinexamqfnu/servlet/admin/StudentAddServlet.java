package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Department;
import com.hp.onlinexamqfnu.po.StuClass;
import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.service.admin.IStuClassService;
import com.hp.onlinexamqfnu.service.admin.IStudentService;
import com.hp.onlinexamqfnu.service.admin.StuClassService;
import com.hp.onlinexamqfnu.service.admin.StudentService;

/**
 * Servlet implementation class studentAddServlet
 */
@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IStudentService ss=new StudentService();   
    private IStuClassService scs=new StuClassService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> stuClassList=scs.findAll();
		request.setAttribute("classList", stuClassList);
		request.setAttribute("deptList",Department.values());
		
		request.getRequestDispatcher("/manager/studentadd.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String sex=request.getParameter("sex");
		String born=request.getParameter("born");
		String school=request.getParameter("school");
		String deptName=request.getParameter("deptName");
		String classId=request.getParameter("classId");
		/*
		 * 
		 */
		
		
		Student s=new Student();
		s.setId(Integer.valueOf(id));
		s.setName(name);
		s.setPwd(pwd);
		s.setBorn(born);
		s.setSex(sex);
		s.setDeptName(deptName);
		s.setSchool(school);
		//s.setClassId(Integer.valueOf(classId));
		ss.addStudent(s);
		
		
		request.getRequestDispatcher("/StudentQueryServlet").forward(request, response);
		
	}

}

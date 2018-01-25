package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Department;
import com.hp.onlinexamqfnu.po.Student;
import com.hp.onlinexamqfnu.service.admin.IStuClassService;
import com.hp.onlinexamqfnu.service.admin.IStudentService;
import com.hp.onlinexamqfnu.service.admin.StuClassService;
import com.hp.onlinexamqfnu.service.admin.StudentService;

/**
 * Servlet implementation class StudentModifyServlet
 */
@WebServlet("/StudentModifyServlet")
public class StudentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentService ss = new StudentService();
    private IStuClassService scs = new StuClassService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		Student s = ss.findStudentById(id);
		List stuClassList = scs.findAll();
		request.setAttribute("classList", stuClassList);
		request.setAttribute("student",s);
		request.setAttribute("deptList", Department.values());
		request.getRequestDispatcher("/manager/studentmodify.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int stuId = Integer.valueOf(request.getParameter("id"));
		String stuName = request.getParameter("name");
		String stuPwd = request.getParameter("pwd");
		String stuSex = request.getParameter("sex");
		String stuBorn = request.getParameter("born");
		String stuSchool = request.getParameter("school");
		
		int stuClassId = Integer.valueOf(request.getParameter("classId"));
		Student s = new Student();
		s.setId(stuId);
		s.setName(stuName);
		s.setPwd(stuPwd);
		s.setSchool(stuSchool);
		s.setBorn(stuBorn);
		s.setSex(stuSex);
	
		s.setClassId(stuClassId);
		ss.updateStudent(s);
		request.getRequestDispatcher("/StudentQueryServlet").forward(request, response);
	}

}

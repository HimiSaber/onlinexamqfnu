package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Course;
import com.hp.onlinexamqfnu.po.Department;
import com.hp.onlinexamqfnu.service.admin.CourseService;
import com.hp.onlinexamqfnu.service.admin.ICourseService;

/**
 * Servlet implementation class courseAddServlet
 */
@WebServlet("/CourseAddServlet")
public class CourseAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService cs=new CourseService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("depList",Department.values());
		request.getRequestDispatcher("/manager/courseadd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cName=request.getParameter("courname");
		
		
		cs.addCourse(cName);
		request.getRequestDispatcher("/CourseQueryServlet").forward(request, response);
	}

}

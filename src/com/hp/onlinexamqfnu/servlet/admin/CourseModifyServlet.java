package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Course;
import com.hp.onlinexamqfnu.service.admin.CourseService;
import com.hp.onlinexamqfnu.service.admin.ICourseService;

/**
 * Servlet implementation class CourseModifyServlet
 */
@WebServlet("/CourseModifyServlet")
public class CourseModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICourseService cs = new CourseService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("info");
		Course c = cs.findCourseById(Integer.valueOf(id));
		request.setAttribute("course", c);
		request.getRequestDispatcher("manager/coursemodify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String courseName = request.getParameter("courname");
		int id = Integer.valueOf(request.getParameter("id"));
		Course c = new Course();
		c.setId(id);
		c.setName(courseName);
		cs.updateCourse(c);
		request.getRequestDispatcher("/CourseQueryServlet").forward(request, response);
	}

}

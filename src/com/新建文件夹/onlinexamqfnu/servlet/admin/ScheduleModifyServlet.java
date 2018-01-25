package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.Course;
import com.hp.onlinexamqfnu.po.StuClass;
import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.po.TeacherCourse;
import com.hp.onlinexamqfnu.service.admin.CourseService;
import com.hp.onlinexamqfnu.service.admin.ICourseService;
import com.hp.onlinexamqfnu.service.admin.IStuClassService;
import com.hp.onlinexamqfnu.service.admin.ITeacherService;
import com.hp.onlinexamqfnu.service.admin.StuClassService;
import com.hp.onlinexamqfnu.service.admin.TeacherService;
import com.hp.onlinexamqfnu.vo.TeacherCourseView;

/**
 * Servlet implementation class ScheduleModifyServlet
 */
@WebServlet("/ScheduleModifyServlet")
public class ScheduleModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ICourseService cs=new CourseService();
       private IStuClassService scs=new StuClassService();
   	private ITeacherService ts=new TeacherService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("info"));
		TeacherCourse tc=cs.findTeacherCourseById(id);
		request.setAttribute("teaCourId", id);
		List<Map<String, Object>> stuClassList=scs.findAll();
		List<Teacher> teacherList=ts.findAll();
		
		Course c=cs.findCourseById(tc.getCourseId());
		List<Course> course=cs.findAllCourses(c.getName());
		request.setAttribute("stuclList",stuClassList);
		request.setAttribute("courList",course);
		request.setAttribute("teaList",teacherList);
		request.getRequestDispatcher("/manager/schedulemodify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.valueOf(request.getParameter("teaCourId"));
		
		String teacherId=request.getParameter("teacher");
		String stuclassId=request.getParameter("stuclass");
		
		TeacherCourse tc=new TeacherCourse();
		
		tc.setId(id);
		tc.setClassId(Integer.valueOf(stuclassId));
		tc.setTeaId(Integer.valueOf(teacherId));
		cs.modifyTeacherCourse(tc);
		request.getRequestDispatcher("/ScheduleQueryServlet").forward(request, response);
	}

}

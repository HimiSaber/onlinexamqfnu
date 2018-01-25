package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.StuClass;
import com.hp.onlinexamqfnu.po.Teacher;
import com.hp.onlinexamqfnu.service.admin.IStuClassService;
import com.hp.onlinexamqfnu.service.admin.ITeacherService;
import com.hp.onlinexamqfnu.service.admin.StuClassService;
import com.hp.onlinexamqfnu.service.admin.TeacherService;

/**
 * Servlet implementation class TeacherQueryServlet
 */
@WebServlet("/TeacherQueryServlet")
public class TeacherQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITeacherService ts=new TeacherService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Teacher> TeacherList=ts.findAll();
		/*
		 * 把业务层返回的结果保存到request里面
		 * 通过setAttribute
		 */
		request.setAttribute("teacherList",TeacherList);
		/*
		 * 如果需要向页面传递数据 
		 * 必须用get
		 */
		request.getRequestDispatcher("manager/teachermanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

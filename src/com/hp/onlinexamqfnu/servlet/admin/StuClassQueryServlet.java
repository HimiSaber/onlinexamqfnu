package com.hp.onlinexamqfnu.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.po.StuClass;
import com.hp.onlinexamqfnu.service.admin.IStuClassService;
import com.hp.onlinexamqfnu.service.admin.StuClassService;

/**
 * Servlet implementation class StuclassQueryServlet
 */
@WebServlet("/StuClassQueryServlet")
public class StuClassQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStuClassService scs=new StuClassService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuClassQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> stuClassList=scs.findAll();
		/*
		 * 把业务层返回的结果保存到request里面
		 * 通过setAttribute
		 */
		request.setAttribute("scList",stuClassList);
		
		/*
		 * 如果需要向页面传递数据 
		 * 必须用get
		 */
		request.getRequestDispatcher("manager/stuclassmanage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

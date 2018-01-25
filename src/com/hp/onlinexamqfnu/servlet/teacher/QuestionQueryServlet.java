package com.hp.onlinexamqfnu.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexamqfnu.service.teacher.IQuestionService;
import com.hp.onlinexamqfnu.service.teacher.ITestService;
import com.hp.onlinexamqfnu.service.teacher.QuestionService;
import com.hp.onlinexamqfnu.service.teacher.TestService;

/**
 * Servlet implementation class TestQueryServlet
 */
@WebServlet("/QuestionQueryServlet")
public class QuestionQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IQuestionService qs=new QuestionService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionQueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchKey = request.getParameter("selectk");
		String searchValue = request.getParameter("searchName");
		if (null != searchValue)
		searchValue = new String(searchValue.getBytes("ISO-8859-1"), "utf-8");
		List<Map<String,Object>> queList = qs.findAll(searchKey, searchValue);
		request.setAttribute("queList", queList);

		request.getRequestDispatcher("/teacher/questionmanage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

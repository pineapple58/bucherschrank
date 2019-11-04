package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/DeleteBookAction")
public class DeleteBookAction extends HttpServlet {

	private static String pass = "/WEB-INF/view/bookdelete.jsp";
	private static String adminpass = "/WEB-INF/view/testadmintop.jsp";
	HashMap<Integer, String> userList = null;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(pass);
		dispatcher.forward(request, response);

	}

}
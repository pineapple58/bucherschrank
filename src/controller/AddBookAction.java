package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.BookList;
import model.BookRegistration;
import model.LoginForm;
import model.UserList;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/AddBookAction")
public class AddBookAction extends HttpServlet {

	private static String pass = "/WEB-INF/view/bookregist.jsp";
	private static String adminpass = "/WEB-INF/view/testadmintop.jsp";
	HashMap<Integer, String> userList = null;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

		String empId = request.getParameter("empId");
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String imageurl = request.getParameter("imageUrl");
		String price = request.getParameter("price");

		BookRegistration bookregistration = new BookRegistration();
		try {
			if (!bookregistration.bookRegist(empId, title, summary, imageurl, price)) {

				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<body>");
				out.println("登録失敗");
				out.println(
						"<form action=\"/bucherschrank/AddBookAction\" method=\"GET\" name=\"form1\"><input type=\"hidden\" value=\"再登録\"><a href=\"javascript:form1.submit()\">再登録</a></form>");
				out.println("</body>");
				out.println("</html>");

			} else {
				HttpSession session = request.getSession();
				session.removeAttribute("bookList");
				session.removeAttribute("rentalBookList");

				LoginForm loginform = new LoginForm();

				List<Book> bookList = new BookList().getBookList();
				List<Book> rentalBookList = new BookList().getRentalBookList(loginform);

				session.setAttribute("bookList", bookList);
				session.setAttribute("rentalBookList", rentalBookList);

				RequestDispatcher dispatcher = request.getRequestDispatcher(adminpass);
				dispatcher.forward(request, response);
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		try {

			userList = new UserList().getUserList();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(pass);
		dispatcher.forward(request, response);

	}

}
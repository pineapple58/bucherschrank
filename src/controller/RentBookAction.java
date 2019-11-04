package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import model.BookList;
import model.BookRental;
import model.LoginForm;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/RentBookAction")
public class RentBookAction extends HttpServlet {

	private static String adminpass = "/WEB-INF/view/testadmintop.jsp";
	private static String pass = "/WEB-INF/view/testtop.jsp";

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {
			request.setCharacterEncoding("UTF-8");

			BookRental bookrental = new BookRental();
			LoginForm loginform = new LoginForm();

			HttpSession session = request.getSession();
			loginform = (LoginForm) session.getAttribute("loginform");
			int empId = loginform.getEMP_ID();
			int ATSUKAI_F = loginform.getATSUKAI_F();

			Map map = request.getParameterMap();
			Iterator it = map.keySet().iterator();
			String bookId = (String) it.next();



			if (!bookrental.bookRental(bookId, empId)) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<body>");
				out.println("レンタル失敗");
				out.println(
						"<button type=\"button\" onclick=\"history.back()\">戻る</button>");
				out.println("</body>");
				out.println("</html>");

			} else {

				if (ATSUKAI_F == 1) {
					session.removeAttribute("bookList");
					session.removeAttribute("rentalBookList");
					List<Book> bookList = new BookList().getBookList();
					List<Book> rentalBookList = new BookList().getRentalBookList(loginform);

					session.setAttribute("bookList", bookList);
					session.setAttribute("rentalBookList", rentalBookList);

					RequestDispatcher dispatcher = request.getRequestDispatcher(adminpass);
					dispatcher.forward(request, response);
				} else {
					session.removeAttribute("bookList");
					session.removeAttribute("rentalBookList");
					List<Book> bookList = new BookList().getBookList();
					List<Book> rentalBookList = new BookList().getRentalBookList(loginform);

					session.setAttribute("bookList", bookList);
					session.setAttribute("rentalBookList", rentalBookList);

					RequestDispatcher dispatcher = request.getRequestDispatcher(pass);
					dispatcher.forward(request, response);
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

/*	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}*/

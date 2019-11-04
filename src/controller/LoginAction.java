package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import model.LoginCheck;
import model.LoginForm;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String adminpass = "/WEB-INF/view/testadmintop.jsp";
	private static String pass = "/WEB-INF/view/testtop.jsp";
	private static String falsepass = "/WEB-INF/view/login.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// パラメータの取得
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		LoginForm loginform = new LoginForm(userName, password);
		LoginCheck logincheck = new LoginCheck();

		// ログインチェック
		try {
			if (logincheck.check(loginform)) {

				/*				HttpSession session = request.getSession();
								session.setAttribute("loginform", loginform);*/

				//ユーザーの扱いフラグが1ならadminページ
				if (loginform.getATSUKAI_F() == 1) {

					List<Book> bookList = new BookList().getBookList();
					List<Book> rentalBookList = new BookList().getRentalBookList(loginform);

					if (bookList == null || rentalBookList == null) {
						response.setContentType("text/html; charset=Shift-JIS");
						PrintWriter out = response.getWriter();
						out.println("<!DOCTYPE html>");
						out.println("<html>");
						out.println("<body>");
						out.println("adminページ こっちに本の登録削除変更検索全ての機能");
						out.println(
								"<form action=\"/bucherschrank/LogoutAction\" method=\"GET\" name=\"form1\"><input type=\"hidden\" value=\"ログアウト\"><a href=\"javascript:form1.submit()\">ログアウト</a></form>");
						out.println(
								"<form action=\"/bucherschrank/AddBookAction\" method=\"GET\" name=\"form2\"><input type=\"hidden\" value=\"蔵書登録\"><a href=\"javascript:form2.submit()\">蔵書登録</a></form>");
						out.println("</body>");
						out.println("</html>");
					}
					HttpSession session = request.getSession();
					request.setAttribute("bookList", bookList);
					request.setAttribute("rentalBookList", rentalBookList);

					session.setAttribute("loginform", loginform);
					session.setAttribute("bookList", bookList);
					session.setAttribute("rentalBookList", rentalBookList);

					// adminTop画面に遷移
					RequestDispatcher dispatcher = request.getRequestDispatcher(adminpass);
					dispatcher.forward(request, response);
				}
				//ユーザーの扱いフラグが1以外なら通常ページ
				else {
					List<Book> bookList = new BookList().getBookList();
					List<Book> rentalBookList = new BookList().getRentalBookList(loginform);

					HttpSession session = request.getSession();
					request.setAttribute("bookList", bookList);
					request.setAttribute("rentalBookList", rentalBookList);

					session.setAttribute("loginform", loginform);
					session.setAttribute("bookList", bookList);
					session.setAttribute("rentalBookList", rentalBookList);

					RequestDispatcher dispatcher = request.getRequestDispatcher(pass);
					dispatcher.forward(request, response);
				}
			} else {
				//login画面に戻る
				RequestDispatcher dispatcher = request.getRequestDispatcher(falsepass);
				dispatcher.forward(request, response);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(falsepass);
		dispatcher.forward(request, response);

	}

}
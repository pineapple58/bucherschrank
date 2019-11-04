package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SignUp;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/SignupAction")
public class SignupAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String pass = "/WEB-INF/view/signup.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// パラメータの取得
		String empId = request.getParameter("empId");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("password");
		String adress = request.getParameter("adress");

		//入力されていない項目があった場合、メッセージ出力
		if(empId == null || userName.isEmpty() || pass.isEmpty() || adress.isEmpty()) {
			response.setContentType("text/html; charset=Shift-JIS");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<body>");
	        out.println("入力項目に不備があります");
			out.println("<form action=\"/bucherschrank/SignupAction\" method=\"GET\" name=\"form1\"><input type=\"hidden\" value=\"登録\"><a href=\"javascript:form1.submit()\">新規登録</a></form>");
			out.println("<form action=\"/bucherschrank/TopController\" method=\"GET\" name=\"form2\"><input type=\"hidden\" value=\"Top\"><a href=\"javascript:form2.submit()\">Top</a></form>");
			out.println("</body>");
	        out.println("</html>");
		}

		SignUp signup = new SignUp();
		//すべての入力項目に値が入っていればInsertしにいく
		try {
			signup.regist(empId, userName, pass, adress);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//登録完了メッセージ出力
		response.setContentType("text/html; charset=Shift-JIS");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("登録完了");
		out.println("<form action=\"/bucherschrank/LoginAction\" method=\"GET\" name=\"form1\"><input type=\"hidden\" value=\"ログイン\"><a href=\"javascript:form1.submit()\">ログイン画面へ</a></form>");
		out.println("<form action=\"/bucherschrank/TopController\" method=\"GET\" name=\"form2\"><input type=\"hidden\" value=\"Top\"><a href=\"javascript:form2.submit()\">Top</a></form>");
		out.println("</body>");
        out.println("</html>");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(pass);
		dispatcher.forward(request, response);

	}
}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/LogoutAction")
public class LogoutAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession(true);
		session.invalidate();

		response.setContentType("text/html; charset=Shift-JIS");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("ログアウトしました");
		out.println("<form action=\"/bucherschrank/TopController\" method=\"GET\" name=\"form1\"><input type=\"hidden\" value=\"Topへ\"><a href=\"javascript:form1.submit()\">Topへ</a></form>");
		out.println("</body>");
        out.println("</html>");
	}
}
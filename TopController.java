package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.TopLogic;

/**
 * Servlet implementation class TopController
 */
@WebServlet("/TopController")
public class TopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String path = "/WEB-INF/view/top.jsp";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Book> bookList = new TopLogic().getBookList();
		List<Book> rentalBookList = new TopLogic().getRentalBookList();

		request.setAttribute("bookList", bookList);
		request.setAttribute("rentalBookList", rentalBookList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}



}

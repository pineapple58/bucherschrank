package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookList {
	protected Connection con = null;
	int count = 0;

	public List<Book> getBookList() throws ClassNotFoundException, SQLException {

		List<Book> bookList = new ArrayList<Book>();

		String url = "jdbc:mysql://localhost:3306/acro_bookshelf?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String password = "0123";

		//MySQLに接続
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);

		/*if (!bookCount(con)) {
			con.close();
			return bookList;
		}*/

		Statement statement = con.createStatement();
		String sql = "select * from tbl_book";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getInt("BOOK_ID"));
			book.setEmpId(rs.getInt("EMP_ID"));
			book.setTitle(rs.getString("TITLE"));
			book.setSummary(rs.getString("SUMMARY"));
			book.setImageUrl(rs.getString("IMAGE"));
			book.setPrice(rs.getInt("PRICE"));

			bookList.add(book);
		}

		con.close();
		return bookList;

	}

	public List<Book> getRentalBookList(LoginForm loginform) throws ClassNotFoundException, SQLException {

		int empId = loginform.getEMP_ID();
		List<Book> rentalBookList = new ArrayList<Book>();

		String url = "jdbc:mysql://localhost:3306/acro_bookshelf?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String password = "0123";

		//MySQLに接続
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);

		/*		if (!bookCount(con)) {
					con.close();
					return rentalBookList;
				}*/

		String sql = "select * from tbl_book where EMP_ID = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getInt("BOOK_ID"));
			book.setEmpId(rs.getInt("EMP_ID"));
			book.setTitle(rs.getString("TITLE"));
			book.setSummary(rs.getString("SUMMARY"));
			book.setImageUrl(rs.getString("IMAGE"));
			book.setPrice(rs.getInt("PRICE"));

			rentalBookList.add(book);
		}

		con.close();
		return rentalBookList;

	}

	/*public boolean bookCount(Connection con) throws SQLException {

		Statement statement = con.createStatement();
		String sql = "select count(*) AS count from tbl_book";
		ResultSet rs = statement.executeQuery(sql);

		if (rs.next()) {
			if(rs.getInt("count")==0) {
				return false;
			}
			return true;
		}else {
			return false;
		}
	}*/
}

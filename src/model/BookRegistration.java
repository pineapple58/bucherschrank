package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookRegistration {
	protected Connection con = null;

	public boolean bookRegist(String empId, String title, String summary, String imageurl, String price) throws SQLException {

		try {

			if (title.isEmpty()) {
				return false;
			}

			Book book = new Book();

			String url = "jdbc:mysql://localhost:3306/acro_bookshelf?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "0123";

			//MySQLに接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			//件数カウント、カウントに+１した値をbook_idとする
			if(!bookCount(book, con)) {
				return false;
			}

			//insert
			String sql = "insert into tbl_book(BOOK_ID, EMP_ID, TITLE, SUMMARY, IMAGE, PRICE) values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, book.getBookId());
			pstmt.setString(2, empId);
			pstmt.setString(3, title);
			pstmt.setString(4, summary);
			pstmt.setString(5, imageurl);
			pstmt.setString(6, price);

			pstmt.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}
	}

	public boolean bookCount(Book book, Connection con)  throws SQLException {

		Statement statement=con.createStatement();
		String sql = "select count(*) AS count from tbl_book";
		ResultSet rs = statement.executeQuery(sql);


		if (rs.next()){
			book.setBookId(rs.getInt("count")+1);
	        return true;
	    }else{
	        return false;
	    }

	}
}

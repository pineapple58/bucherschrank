package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookRental {
	protected Connection con = null;

	public boolean bookRental(String bookId, int empId) throws SQLException {

		try {

			if (bookId.isEmpty()) {
				return false;
			}

			String url = "jdbc:mysql://localhost:3306/acro_bookshelf?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "0123";

			//MySQLに接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			//insert
			String sql = "update tbl_book set EMP_ID = ? where BOOK_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, empId);
			pstmt.setString(2, bookId);

			pstmt.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}
	}
}

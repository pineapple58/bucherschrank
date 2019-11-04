package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

public class SignUp extends HttpServlet {
	protected Connection con = null;

	public boolean regist(String empId, String userName, String pass, String adress) throws SQLException {
		try {

			String url = "jdbc:mysql://localhost:3306/acro_bookshelf?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "0123";

			//MySQLに接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			//insert
			String sql = "insert into tbl_user(EMP_ID,USER_NAME,PASS,ADRESS,ATSUKAI_F) values(?,?,?,?,0)";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, empId);
			pstmt.setString(2, userName);
			pstmt.setString(3, pass);
			pstmt.setString(4, adress);

			pstmt.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			con.close();
		}
	}
}

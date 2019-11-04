package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

public class LoginCheck extends HttpServlet {
	protected Connection con = null;

	public boolean check(LoginForm loginform) throws SQLException {

		String userName = loginform.getUserName();
		String userPassword = loginform.getPassword();

		if (userName == null || userName.isEmpty() || userPassword == null || userPassword.isEmpty()) {
			return false;
		}

		try {
			String url = "jdbc:mysql://localhost:3306/acro_bookshelf?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "0123";

			//MySQLに接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			//テーブルから一致するものだけとってくる
			String sql = "SELECT * FROM tbl_user WHERE USER_NAME = ? && PASS = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPassword);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				loginform.setATSUKAI_F(rs.getInt("ATSUKAI_F"));
				loginform.setEMP_ID(rs.getInt("EMP_ID"));
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}
	}
}
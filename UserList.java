package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class UserList {
	protected Connection con = null;

	public HashMap<Integer, String> getUserList() throws ClassNotFoundException, SQLException {

		HashMap<Integer, String> userList = new HashMap<Integer, String>();

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
		String sql = "select * from tbl_user";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

			userList.put(rs.getInt("EMP_ID"), rs.getString("USER_NAME"));
		}

		con.close();
		return userList;

	}

}

package jdbc;

import java.sql.*;

/**
 * We can create a separate class for establishing and closing the connections.
 * As it been used commonly
 */
public class JDBCUtil {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localHost:3306/jdbcconnection", "root", "root");
	}
	
	public static void  closeConnections(Connection connect,Statement statement) throws SQLException {
		connect.close();
		statement.close();
	}

}

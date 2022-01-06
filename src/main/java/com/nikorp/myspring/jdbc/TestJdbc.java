package com.nikorp.myspring.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
	public static void main(String[] args) throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost:3306/myspring?useSSL=false";
		String user = "root";
		String pwd = "Polaris!23";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcUrl, user, pwd);
			System.out.println(connection.isClosed());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
	}
}

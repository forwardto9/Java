package com.uwei.DBDemo;

import java.sql.*;

public class DBDemo {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL      = "jdbc:mysql://localhost:3306/uwei";
	
	static final String USER        = "root";
	static final String PASSWORD    = "root";
	public DBDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement   stmt = null;
//		 try {
			try {
				Class.forName(JDBC_DRIVER);
				System.out.println("Connect DB");
				
				conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				System.out.println("Instance Statement");
				
				stmt = conn.createStatement();
				String sql = "select * from uwei_table";
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					System.out.println("id = " + id);
					System.out.println("name = " + name);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("DB Demo is Done");
			
//		 }

	}

}

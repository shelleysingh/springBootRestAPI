package com.ecommerce.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

			public static Connection getConnection() throws Exception{
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "123456");

			return conn;
		}

	}

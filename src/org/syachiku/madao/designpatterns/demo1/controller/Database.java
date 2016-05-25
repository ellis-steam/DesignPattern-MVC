package org.syachiku.madao.designpatterns.demo1.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * to show the use of singleton pattern
 * 
 * @author Ellis
 * @since 2016-05-25
 */
public class Database {
	
	private static Database instance = new Database();
	
	private Connection con;
	
	private Database(){
		
	}
	
	public static Database getInstance(){
		return instance;
	}
	
	public void connect() throws Exception{
		if (con != null)
			return;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new Exception("Driver not found");
		}

		String url = String.format("jdbc:mysql://localhost:%d/webshop", 3306);

		con = DriverManager.getConnection(url, "root", "sf0701");
	}
	
	public void disconnect(){
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Can't close connection");
			}
		}
		
		con = null;
	}
}

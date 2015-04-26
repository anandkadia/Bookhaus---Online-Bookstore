package com.bookhaus.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	public final static String USERNAME="root";
	public final static String PASSWORD="root";
	public final static String DB_STRING = "jdbc:mysql://localhost:3306/bookhaus_db";
	
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //loading JDBC driver for MySQL
		} catch (ClassNotFoundException e) {
			System.err.println("Could not load MySQL JDBC driver. " +  e.getMessage());
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(DB_STRING, USERNAME, PASSWORD); //connecting to the MySQL DB
			System.out.println("Connected to the database.");
		} catch (SQLException e) {
			System.err.println("Error in connecting to the database. " +  e.getMessage());
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void cleanup (PreparedStatement ps, ResultSet rs, Connection con){
		try {
			if(ps != null){
				ps.close();
			}
			
			if(rs != null){
				rs.close();
			}
			
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		DBManager.getConnection();
	}
}

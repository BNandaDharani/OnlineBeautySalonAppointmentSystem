package com.virtusa.onlineBeautySalonProject;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DBConnectionImplementation implements DBConnection {


	    @Override
	    public Connection getConnection() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineBeautySalon" , "root", "1234");
	            return con;
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	}



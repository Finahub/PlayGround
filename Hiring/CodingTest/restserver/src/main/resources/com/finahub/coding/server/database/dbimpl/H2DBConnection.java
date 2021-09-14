package com.finahub.coding.server.database.dbimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.finahub.coding.server.database.inter.DatabaseConnectionInterface;

public class H2DBConnection implements DatabaseConnectionInterface {
	
	private static H2DBConnection h2dbconnection= new H2DBConnection();
	
	public static H2DBConnection getH2B() {
		return h2dbconnection;
	}
	
	final String JDBC_DRIVER = "org.h2.Driver";   
	final String DB_URL = "jdbc:h2:~/codingtest";  
	   
	final String USER = "sa"; 
	final String PASS = ""; 
	

	public Connection getConnection() {
		Connection conn = null; 
	      try { 
	    	  Class.forName(JDBC_DRIVER);
	    	  System.out.println("Connecting to database..."); 
	    	  conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	      }catch (SQLException sqlexception) {
	    	  System.out.println("Connection to db got with exception"+ sqlexception);
	      }catch (ClassNotFoundException classnotfoundex) {
	    	  System.out.println("Driver calass not found, exception->"+ classnotfoundex);
		} 
		return conn;
	}

}

package com.finahub.coding.server.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
		// JDBC driver name and database URL 
	   static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:~/codingtest";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 
	   
	public static Connection getH2Connection() {
		
		Connection conn = null; 
	    Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER); 
	             
	         //STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         //STEP 3: Execute a query 
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement(); 
	         String sql=null;
				/*
				 *  sql = "CREATE TABLE   BANKINFO " +
				 * "(Bank_id INTEGER not NULL PRIMARY KEY, " + " Bank_Name VARCHAR(255), " +
				 * "Credit_Card_Amount double, " + " Debit_Card_Amount double, " +
				 * " PRIMARY KEY ( Bank_id ))";
				 * 
				 * 
				 * 
				 * stmt.executeUpdate(sql);
				 */
	         System.out.println("Created table in given database..."); 
				
				
				  sql
				  ="insert into BANKINFO (Bank_id,Bank_Name, Credit_Card_Amount, Debit_Card_Amount) values ("
				  +3+",'poi',"+800.0+","+10.0+")"; 
				  int i =stmt.executeUpdate(sql);
				  System.out.println("data inserted successfully" +i);
				  
				 
				  
				/*
				 * sql= "select * from BANKINFO"; ResultSet rs= stmt.executeQuery(sql);
				 * 
				 * while(rs.next()) { System.out.println(rs.getInt(1));
				 * System.out.println(rs.getString(2)); System.out.println(rs.getDouble(3));
				 * System.out.println(rs.getDouble(4)); }
				 */
				 
	         // STEP 4: Clean-up environment 
	         stmt.close(); 
	         conn.close(); 
	      } catch(SQLException se) { 
	         //Handle errors for JDBC 
	         se.printStackTrace(); 
	      } catch(Exception e) { 
	         //Handle errors for Class.forName 
	         e.printStackTrace(); 
	      } finally { 
	         //finally block used to close resources 
	         try{ 
	            if(stmt!=null) stmt.close(); 
	         } catch(SQLException se2) { 
	         } // nothing we can do 
	         try { 
	            if(conn!=null) conn.close(); 
	         } catch(SQLException se){ 
	            se.printStackTrace(); 
	         } //end finally try 
	      } //end try 
	      System.out.println("Goodbye!");
		return conn;
	}
	
	
	public static void main(String[] args) {
		getH2Connection();
	}
	

}

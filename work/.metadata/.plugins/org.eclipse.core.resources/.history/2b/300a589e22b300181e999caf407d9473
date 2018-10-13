package com.bo.jobs;

import java.sql.*;

public class Test {
	public static void main(String[] args) throws SQLException {
		 String url = "jdbc:oracle:thin:localhost:1521:ORCL";
	        String user = "qpay";
	        String pass = "qpay";
	        String sql = "select * from mpgm";
	        Connection con=null;
	        try {
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
	        	 con= DriverManager.getConnection(url, user, pass);
	        	 Statement st = con.createStatement();
	        	 boolean m = st.execute(sql);
	        	 if (m)
	                 System.out.println("inserted successfully : "+sql);
	             else
	                 System.out.println("insertion failed");
	             con.close();
	        	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	}

}

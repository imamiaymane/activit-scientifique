package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Metier.Chercheur;

public class Logindao {
	public boolean login(Chercheur c) throws ClassNotFoundException{
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		boolean status = false;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from chercheur where email = ? and pass = ? "); 
            preparedStatement.setString(1,c.getEmail());
            preparedStatement.setString(2,c.getPass());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	System.out.println("email Rs : " + rs.getString("email"));
            	status = true;
            }
           
        } 
         catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
		return status;
	}
	public String role(Chercheur c) throws ClassNotFoundException{
		Connection conn=SingletonConnection.getConnection();
		String role = null;
		try{
            PreparedStatement preparedStatement = conn.prepareStatement("select profile from chercheur where email = ? and pass = ? "); 
            preparedStatement.setString(1,c.getEmail());
            preparedStatement.setString(2,c.getPass());
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	role = rs.getString("profile");	
				System.out.println("valide");
            }
		}
		catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
		
		return role;
		
		
	}
	
	 private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
}
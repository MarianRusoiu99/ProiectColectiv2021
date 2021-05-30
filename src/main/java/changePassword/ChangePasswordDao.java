package changePassword;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import echipa.EchipaBean;
import login.LoginServlet;
import email.SendEmail;
import passwordGenerator.PasswordGenerator;



 
public class ChangePasswordDao {
	

    public int changePass (ChangePasswordBean password) throws Exception {
    	
    	String UPDATE_PASS = "UPDATE employee SET password = ? WHERE id = ?";
       
        
        int result = 0;

        
        Class.forName("com.mysql.jdbc.Driver");
        
        
        Connection connection = null;
        try {
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/task-manager", "root", "admin");
                
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        
        
try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASS);
            
            preparedStatement.setString(1, password.getNewPass());
            preparedStatement.setInt(2, LoginServlet.userID);
            
            result = preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        
        return result;
    }
    
    
 
    private static void printSQLException(SQLException ex) {
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
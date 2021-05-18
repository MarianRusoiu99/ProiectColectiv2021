package profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.LoginServlet;
//import passwordGenerator.PasswordGenerator;
//import sendMail.SendEmail;
import upper.info.UpperInfoBean;


 
public class ProfileDao {
	
	
    public static ProfileBean setProfile () throws ClassNotFoundException {
    	
    	String SELECT_QUERY = "SELECT last_name, first_name, job, sex, birth_date, email, phone FROM employee WHERE id = ?";
 
    	ProfileBean profile = new ProfileBean();
        String lastName = null;
        String firstName = null;
        String job = null;
        String sex = null;
        String birthDate = null;
        String email = null;
        String phone = null;
        
        
        Class.forName("com.mysql.jdbc.Driver");
        
        
        Connection connection = null;
        try {
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/task-manager", "root", "admin");
                
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        

        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_QUERY);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(1, LoginServlet.userID);
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
                lastName = result1.getString(1);
                System.out.println("LAST NAME: " + lastName);
                firstName = result1.getString(2);
                System.out.println("FIRST NAME: " + firstName);
                job = result1.getString(3);
                sex = result1.getString(4);
                birthDate = result1.getString(5);
                email = result1.getString(6);
                phone = result1.getString(7);
                
                profile.setLastName(lastName);
                profile.setFirstName(firstName);
                profile.setJob(job);
                profile.setSex(sex);
                profile.setBirthDate(birthDate);
                profile.setEmail(email);
                profile.setPhone(phone);
            }
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        return profile;
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


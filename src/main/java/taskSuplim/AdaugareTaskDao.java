package taskSuplim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import login.LoginServlet;

public class AdaugareTaskDao {
	
	public void addTask(int id) throws ClassNotFoundException {
		
		String INSERT_EmpTask = "insert into `task-manager`.employee_task (employee_id,task_id,status) values(?,?,'neterminat')";
		
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
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EmpTask);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setInt(1, LoginServlet.userID);
            preparedStatement.setInt(2, id);
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
            
            
            
            } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
            }
		
		
		
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
package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.LoginServlet;

public class DoneDao {
	
	public void doneTask(int id,String type) throws ClassNotFoundException {
		
		String UPDATE_EmpTask = "UPDATE employee_task SET status = 'finalizat' WHERE task_id  = ?";
		
		String UPDATE_ActivTask = "UPDATE employee SET active_tasks = active_tasks-1 WHERE id = ? ";
		
		String GET_Team = "SELECT team_id FROM employee WHERE id = ? ";
		
        String UPDATE_TeamTask = "UPDATE team_task SET status = 'finalizat' WHERE task_id  = ?";
		
		String UPDATE_ActivTeamTask = "UPDATE team SET active_tasks = active_tasks-1 WHERE id = ? ";
		
		
		
        Class.forName("com.mysql.jdbc.Driver");
        
        
        Connection connection = null;
        try {
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/task-manager", "root", "admin");
                
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        
        if(type.equals("individual")) {
        
        try {
            
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EmpTask);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setInt(1, id);
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
            
            
            
            } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
            }
        
        try {
            
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ActivTask);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setInt(1, LoginServlet.userID);
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
            
            
            
            } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
            }
        
        }
        else {
        	
        	  int echipa = 0;
        	
        	try {
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement2 = connection.prepareStatement(GET_Team);
                //preparedStatement2.setInt(1, 1);
                preparedStatement2.setInt(1, LoginServlet.userID);

                System.out.println(preparedStatement2);
                // Step 3: Execute the query or update query
                
                ResultSet result1 = preparedStatement2.executeQuery();
                if (result1.next()) {
                    echipa = result1.getInt(1);
                }

                } catch (SQLException e) {
                    // process sql exception
                    printSQLException(e);
                }
        	
        	try {
                
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TeamTask);
                //preparedStatement.setInt(1, 1);
                preparedStatement.setInt(1, id);
     
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.executeUpdate();
                
                
                
                } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
                }
            
            try {
                
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ActivTeamTask);
                //preparedStatement.setInt(1, 1);
                preparedStatement.setInt(1, echipa);
     
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.executeUpdate();
                
                
                
                } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
                }
            
        	
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
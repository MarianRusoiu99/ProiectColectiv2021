package taskManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.LoginServlet;
//import passwordGenerator.PasswordGenerator;
//import sendMail.SendEmail;


 
public class EditTaskDao {
	
	
    public int editTask (AddTaskBean task) throws ClassNotFoundException {
        
    	String SELECT_QUERY = "SELECT company_id FROM employee WHERE id = ?";
    	
        String SELECT_TASK_SQL = "SELECT t.id, t.name, t.description, s.name, t.deadline, t.type, t.repetitive"
        		+ "FROM task t, skill s, task_skill ts"
        		+ "WHERE t.company_id = ? and ts.skill_id = s.id and ts.task_id = t.id;";
    	
        String UPDATE_TASK_SQL = "UPDATE task SET name = ?, description = ?, deadline = ?, type = ?, repetitive = ?"
        		+ "WHERE id  = ?";
        
        String SELECT_skill = "SELECT id FROM skill WHERE name = ?";
        
        String UPDATE_TASKskill = "UPDATE task_skill SET skill_id = ?"
        		+ "WHERE task_id  = ?";
       
 
        
        int result = 0;
        int companie = 0;
        Integer id_task = 0;
        Integer id_skill = 0;
        String name = null;
        String description = null;
        String taskSkill = null;
        String deadline = null;
        String type = null;
        String repetitive = null;

        
        
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
                companie = result1.getInt(1);
            }
            

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_TASK_SQL);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(1, LoginServlet.userID);
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
                id_task = result1.getInt(1);
                name = result1.getString(2);
                description = result1.getString(3);
                taskSkill = result1.getString(4);
                deadline = result1.getString(5);
                type = result1.getString(6);
                repetitive = result1.getString(7);
            }
            

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        try {
            
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TASK_SQL);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, task.getNumeTask());
            preparedStatement.setString(2, task.getDescriereTask());
            preparedStatement.setString(3, task.getDeadlineTask());
            preparedStatement.setString(4, task.getTipTask());
            preparedStatement.setString(5, task.getRepetitive());
            preparedStatement.setInt(6, id_task);
            
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
           
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_skill);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setString(1, taskSkill);
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
                id_skill = result1.getInt(1);
            }
            

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        

        	try {
            
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TASKskill);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setInt(1, id_skill);
            preparedStatement.setInt(2, id_task);
            
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
      
        
        return result;
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


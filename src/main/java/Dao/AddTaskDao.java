package Dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import Model.Task;
 
public class AddTaskDao {
 
    public int addTask (Task task) throws ClassNotFoundException {
        
        String INSERT_SKILL_SQL = "INSERT INTO skill" +
                "  (name, company_id) VALUES " 
                + " (?, ?);";
     
        String SELECT_QUERY = "SELECT id FROM company WHERE name = ?";
        
        String INSERT_USERS_SQL = "INSERT INTO task" +
            "  (name, description, deadline, type, repetitive ) VALUES " +
            " (?, ?, ?, ?, ?);";
 
        int result = 0;
 
//        int companie = 0;
        String skill = null;
        
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
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SKILL_SQL);
                //preparedStatement.setInt(1, 1);
                preparedStatement.setString(1, skill);
        //        preparedStatement.setString(2, task.getCompany());
     
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet result1 = preparedStatement.executeQuery();
                if (result1.next()) {
                    skill = result1.getString(1);
                }
           
     
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_QUERY);
            //preparedStatement2.setInt(1, 1);
      //      preparedStatement2.setString(1, task.getCompany());
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
    //            companie = result1.getInt(1);
            }
       
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
 
 
        try {
                
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, task.getTask_name());
            preparedStatement.setString(2, task.getTask_description());
            preparedStatement.setString(3, task.getTask_req());
            preparedStatement.setString(4, task.getTask_type());
            preparedStatement.setString(5, task.getTask_repetition());
            
 
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
package taskManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.LoginServlet;

import employeeManagement.AddEmployeeDao;


 
public class AddTaskDao {
	
	
    public int addTask (AddTaskBean task) throws ClassNotFoundException {
        
    	String SELECT_QUERY = "SELECT company_id, email FROM employee WHERE id = ?";
    	
        String INSERT_TASK_SQL = "INSERT INTO task" +
                "  (name, description, deadline, type, repetitive, contact_email, company_id) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?);";
    	
    	String SELECT_TASKid = "SELECT id FROM task WHERE name = ? and company_id = ?";
    	
    	String INSERT_TASKskill_SQL = "INSERT INTO task_skill" +
                "  (task_id, skill_id) VALUES "
                + " (?, ?);";
    	
       
 
        
        int result = 0;
        int companie = 0;
        String email = null;
        //Integer id_lider = 0;
        Integer id_skill = 0;
        Integer id_task = 0;

        
        
        Class.forName("com.mysql.jdbc.Driver");
        
        
        Connection connection = null;
        try {
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/task-manager", "root", "root");
                
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
                email = result1.getString(2);
            }
            

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        try {
            
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASK_SQL);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, task.getNumeTask());
            preparedStatement.setString(2, task.getDescriereTask());
            preparedStatement.setString(3, task.getDeadlineTask());
            preparedStatement.setString(4, task.getTipTask());
            preparedStatement.setString(5, task.getRepetitive());
            preparedStatement.setString(6, email);
            preparedStatement.setInt(7, companie);
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }        
        
       
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_TASKid);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setString(1, task.getNumeTask());
            preparedStatement2.setInt(2, companie);
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
                id_task = result1.getInt("id");
            }
            

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }

        

        try {
                
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASKskill_SQL);
            
            for (String x : task.getTehnologii()) {
            	//task.getTehnologii().forEach(y -> System.out.println("." + y + "."));
                if(x != "") {
                	id_skill = AddEmployeeDao.verifySkill(x, companie);
			            //preparedStatement.setInt(1, 1);
			            preparedStatement.setInt(1, id_task);
			            preparedStatement.setInt(2, id_skill);
			 
			            System.out.println(preparedStatement);
			            // Step 3: Execute the query or update query
			            result = preparedStatement.executeUpdate();
                }
            }
            
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


package taskSuplim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import login.LoginServlet;
import email.SendEmail;
import passwordGenerator.PasswordGenerator;
import profile.ProfileBean;



 
public class TaskSuplimDao {
	
	public static String getTehnologii(Connection connection, int id_task) {
		
		String tehnologiiTask = null;
		
		 try {
			    
			 
			    String SELECT_TECH = "select t.id,s.name from `task-manager`.task t, `task-manager`.skill s, `task-manager`.task_skill ts where ts.task_id = t.id and ts.skill_id = s.id having t.id = ? ";
		    	
				PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_TECH);
	        
	            preparedStatement2.setInt(1, id_task);
	            System.out.println(preparedStatement2);
	        
	            ResultSet result1 = preparedStatement2.executeQuery();
	        
	            while (result1.next()) {
	            	if(tehnologiiTask != null)
	            		tehnologiiTask = tehnologiiTask+ ", " + result1.getString("s.name");
	            	else 
	            		tehnologiiTask = result1.getString("s.name");
	            }
	        
			    } catch (SQLException e) {
				    // TODO: handle exception
				    printSQLException(e);
			    }
		
		return tehnologiiTask;
		
	}
	
	
	public static List<TaskSuplimBean> viewTask () throws ClassNotFoundException {
        
    	String SELECT_QUERY = "SELECT company_id FROM employee WHERE id = ?";
    	
    	String SELECT_TASK = "SELECT t.id, t.name, t.description, t.deadline, t.repetitive, t.type, t.contact_email FROM `task-manager`.task t WHERE t.company_id = ? having t.id not in (select task_id from `task-manager`.employee_task);";
    	
    	//String SELECT_SKILL = "SELECT ts.skill_id, s.name FROM task_skill ts, skill s, task t WHERE ts.task_id = ? and ts.task_id = t.id and s.company_id = ? and s.id = ts.skill_id;";
    	
    	
    	List<TaskSuplimBean> task = new ArrayList<TaskSuplimBean>();
    	
    	
        int result = 0;
        int companie = 0;
        Integer id_task = 0;
        Integer id_skill = 0;
        String numeTask = null;
        String descriereTask = null;
        String deadlineTask = null;
        String repetitiveTask = null;
        String tipTask = null;
        String contactTask = null;
        String tehnologiiTask = null;

        
        
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
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_TASK);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(1, companie);
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            
            ResultSet result1 = preparedStatement2.executeQuery();
            while (result1.next()) {
                id_task = result1.getInt(1);
                numeTask = result1.getString(2);
                descriereTask = result1.getString(3);
                deadlineTask = result1.getString(4);
                repetitiveTask = result1.getString(5);
                tipTask = result1.getString(6);
                contactTask = result1.getString(7);
                
                TaskSuplimBean task_aux = new TaskSuplimBean();
                
                task_aux.setIdTask(id_task);
                task_aux.setNumeTask(numeTask);
                task_aux.setDescriereTask(descriereTask);
                task_aux.setDeadlineTask(deadlineTask);
                task_aux.setRepetitiveTask(repetitiveTask);
                task_aux.setTipTask(tipTask);
                task_aux.setContactTask(contactTask);
                task_aux.setTehnologiiTask(getTehnologii(connection,id_task));
                
                
                task.add(task_aux);
                System.out.println("!!! " + task_aux.getIdTask());
                
                
            }
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
      
        
        return task;
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
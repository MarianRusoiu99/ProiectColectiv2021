package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import login.LoginServlet;
import taskSuplim.TaskSuplimBean;
import taskSuplim.TaskSuplimDao;

public class TaskDao {
	
public static List<TaskSuplimBean> viewTask () throws ClassNotFoundException {
        
    	
    	String SELECT_TASK = "SELECT t.id, t.name, t.description, t.deadline, t.repetitive, t.type, t.contact_email "
    			+ "FROM task t, employee_task et  WHERE et.task_id = t.id and et.employee_id = ? and et.status = 'neterminat'";
    	
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
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_TASK);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(1, LoginServlet.userID);
 
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
                task_aux.setTehnologiiTask(TaskSuplimDao.getTehnologii(connection,id_task));
                
                
                task.add(task_aux);
                System.out.println("!!! " + task_aux.getIdTask());
                
                
            }
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
      
        
        return task;
    }

public static List<TaskSuplimBean> viewTeamTasks () throws ClassNotFoundException {
    
    String SELECT_QUERY = "SELECT team_id FROM employee WHERE id = ?";
    
    String SELECT_TASK = "SELECT t.id, t.name, t.description, t.deadline, t.repetitive, t.type, t.contact_email "
    		+ "FROM task t, team_task tt  "
    		+ "WHERE tt.task_id = t.id and tt.team_id = ? and tt.status = 'neterminat'";
    
    
    List<TaskSuplimBean> task = new ArrayList<TaskSuplimBean>();
    
    int echipa = 0;
    int id_task = 0;
    String numeTask = null;
    String descriereTask = null;
    String deadlineTask = null;
    String repetitiveTask = null;
    String tipTask = null;
    String contactTask = null;
    
    
    
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
            echipa = result1.getInt(1);
        }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
    
    
    
    try {
        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_TASK);
        //preparedStatement2.setInt(1, 1);
        preparedStatement2.setInt(1, echipa);

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
            task_aux.setTehnologiiTask(TaskSuplimDao.getTehnologii(connection,id_task));
            
            
            task.add(task_aux);
            System.out.println("!!! ID " + task_aux.getIdTask());
            
            
        }
        
    } catch (SQLException e) {
        // process sql exception
        printSQLException(e);
    }
    
    
    return task;
}
    
public static List<TaskSuplimBean> viewCompleteTasks () throws ClassNotFoundException {
	
	String SELECT_TASK = "SELECT t.id, t.name, t.description, t.deadline, t.repetitive, t.type, t.contact_email "
			+ "FROM task t, employee_task et  "
			+ "WHERE et.task_id = t.id and et.employee_id = ? and et.status = 'finalizat'";
    
    String SELECT_QUERY = "SELECT team_id FROM employee WHERE id = ?";
    
    String SELECT_TeamTASK = "SELECT t.id, t.name, t.description, t.deadline, t.repetitive, t.type, t.contact_email "
    		+ "FROM task t, team_task tt  "
    		+ "WHERE tt.task_id = t.id and tt.team_id = ? and tt.status = 'finalizat'";
    
    
    List<TaskSuplimBean> task = new ArrayList<TaskSuplimBean>();
    
    int echipa = 0;
    int id_task = 0;
    String numeTask = null;
    String descriereTask = null;
    String deadlineTask = null;
    String repetitiveTask = null;
    String tipTask = null;
    String contactTask = null;
    
    
    
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
        PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_TASK);
        //preparedStatement2.setInt(1, 1);
        preparedStatement2.setInt(1, LoginServlet.userID);

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
            task_aux.setTehnologiiTask(TaskSuplimDao.getTehnologii(connection,id_task));
            
            
            task.add(task_aux);
            System.out.println("!!! " + task_aux.getIdTask());
            
            
        }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
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
            echipa = result1.getInt(1);
        }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
    
    
    
    try {
        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_TeamTASK);
        //preparedStatement2.setInt(1, 1);
        preparedStatement2.setInt(1, echipa);

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
            task_aux.setTehnologiiTask(TaskSuplimDao.getTehnologii(connection,id_task));
            
            
            task.add(task_aux);
            System.out.println("!!! ID " + task_aux.getIdTask());
            
            
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

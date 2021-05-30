package taskManagement;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
 
import login.LoginServlet;
 
import employeeManagement.AddEmployeeDao;
 
 
 
public class AddTaskDao {
    
    
    public boolean impartireAutomata(AddTaskBean task, Connection connection, int company_id, int task_id) {
        
        String SELECT_EMPs = "SELECT id, active_tasks FROM employee WHERE company_id = ?;";
        
        String SELECT_Teams = "SELECT id, active_tasks FROM team WHERE company_id = ?;";
        
        String SELECT_SKILLs = "SELECT s.name "
                + "FROM skill s, employee e, employee_skill es "
                + "WHERE e.id = ? and es.employee_id = e.id and s.id = es.skill_id;";
        
        String SELECT_TeamSKILLs = "SELECT s.name "
                + "FROM skill s, team t, team_skill ts "
                + "WHERE t.id = ? and ts.team_id = t.id and s.id = ts.skill_id;";
        
        String INSERT_EmpTask = "INSERT INTO employee_task (employee_id, task_id,status) VALUES (?,?,'neterminat')";
        
        String INSERT_TeamTask = "INSERT INTO team_task (team_id, task_id,status) VALUES (?,?,'neterminat')";
        
        String UPDATE_ActivTask = "UPDATE employee SET active_tasks = active_tasks+1 WHERE id = ? ";
        
        String UPDATE_ActivTaskTeam = "UPDATE team SET active_tasks = active_tasks+1 WHERE id = ? ";
        
        
        Set<String> tehnologii = new HashSet<String>();
        Set<String> skills = new HashSet<String>();
        
        int id_emp = 0;
        int active_tasks = 0;
        String skillName = null;
        
        
        for(String x : task.getTehnologii()) {
            
            if(x != "") {
                tehnologii.add(x.toLowerCase());
            }
            
        }
        
        System.out.println(tehnologii);
        
        System.out.println(task.getTipTask());
        
        
        if(task.getTipTask().toLowerCase().equals("individual")) {
        
        try {
        	System.out.println("TRY 1 E");
        	
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_EMPs);
            
            preparedStatement2.setInt(1, company_id);
 
            System.out.println(preparedStatement2);
            
            ResultSet result1 = preparedStatement2.executeQuery();
            while (result1.next()) {
                id_emp = result1.getInt(1);
                active_tasks = result1.getInt(2);
                
                
                if(active_tasks < 5) {
                                        
                
                
                try {
                	System.out.println("TRY 2 E");
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SKILLs);
                    
                    preparedStatement.setInt(1, id_emp);
         
                    System.out.println(preparedStatement);
                    
                    ResultSet result = preparedStatement.executeQuery();
                    while (result.next()) {
                            
                            skills.add(result.getString(1).toLowerCase());
                                                    
                    }
                    
 
                 } catch (SQLException e) {
                        // process sql exception
                        printSQLException(e);
                 }
                
                
                
                
                if(skills.equals(tehnologii)) {
                    
                    try {
                    	System.out.println("TRY 3 E");
                        // Step 2:Create a statement using connection object
                        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EmpTask);
                        //preparedStatement.setInt(1, 1);
                        preparedStatement.setInt(1, id_emp);
                        preparedStatement.setInt(2, task_id);
             
                        System.out.println(preparedStatement);
                        // Step 3: Execute the query or update query
                        preparedStatement.executeUpdate();
                        
                        
                        
                        } catch (SQLException e) {
                        // process sql exception
                        printSQLException(e);
                        }
                    
                    try {
                    	System.out.println("TRY 4 E");
                        // Step 2:Create a statement using connection object
                        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ActivTask);
                        //preparedStatement.setInt(1, 1);
                        preparedStatement.setInt(1, id_emp);
             
                        System.out.println(preparedStatement);
                        // Step 3: Execute the query or update query
                        preparedStatement.executeUpdate();
                        
                        
                        
                        } catch (SQLException e) {
                        // process sql exception
                        printSQLException(e);
                        }
                    
                    return true;
                    
                }
                
            }
         }
            
 
         } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
         }
        }
        
        else {
        	
        	try {
            	System.out.println("TRY 1 T");
            	
                PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_Teams);
                
                preparedStatement2.setInt(1, company_id);
     
                System.out.println(preparedStatement2);
                
                ResultSet result1 = preparedStatement2.executeQuery();
                while (result1.next()) {
                   int id_team = result1.getInt(1);
                    active_tasks = result1.getInt(2);
                    
                    
                    if(active_tasks < 5) {
                                            
                    
                    
                    try {
                    	System.out.println("TRY 2 T");
                        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TeamSKILLs);
                        
                        preparedStatement.setInt(1, id_team);
             
                        System.out.println(preparedStatement);
                        
                        ResultSet result = preparedStatement.executeQuery();
                        while (result.next()) {
                                
                                skills.add(result.getString(1).toLowerCase());
                                                        
                        }
                        
     
                     } catch (SQLException e) {
                            // process sql exception
                            printSQLException(e);
                     }
                    
                    
                    
                    
                    if(skills.equals(tehnologii)) {
                        
                        try {
                        	System.out.println("TRY 3 T");
                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TeamTask);
                            //preparedStatement.setInt(1, 1);
                            preparedStatement.setInt(1, id_team);
                            preparedStatement.setInt(2, task_id);
                 
                            System.out.println(preparedStatement);
                            // Step 3: Execute the query or update query
                            preparedStatement.executeUpdate();
                            
                            
                            
                            } catch (SQLException e) {
                            // process sql exception
                            printSQLException(e);
                            }
                        
                        try {
                        	
                        	System.out.println("TRY 4 T");
                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ActivTaskTeam);
                            //preparedStatement.setInt(1, 1);
                            preparedStatement.setInt(1, id_team);
                 
                            System.out.println(preparedStatement);
                            // Step 3: Execute the query or update query
                            preparedStatement.executeUpdate();
                            
                            
                            
                            } catch (SQLException e) {
                            // process sql exception
                            printSQLException(e);
                            }
                        
                        return true;
                        
                    }
                    
                }
             }
                
     
             } catch (SQLException e) {
                    // process sql exception
                    printSQLException(e);
             }
            }
        	
        
        
        
        return false;
        
    }
    
    
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
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/task-manager", "root", "admin");
                
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        
        
        // functie de impartire
        
        
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
        
        
        impartireAutomata(task, connection, companie, id_task);
        
        
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
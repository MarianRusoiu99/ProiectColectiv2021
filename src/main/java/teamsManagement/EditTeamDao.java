package teamsManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import login.LoginServlet;
//import passwordGenerator.PasswordGenerator;
//import sendMail.SendEmail;


 
public class EditTeamDao {
	
	
    public int editTeam (AddTeamBean team) throws ClassNotFoundException {
        
    	String SELECT_QUERY = "SELECT company_id FROM employee WHERE id = ?";
    	
        String INSERT_TEAM_SQL = "SELECT t.name, t.leader_email, e.email, s.name as skill, ts.skill_id"
        		+ "FROM team t, employee e, skill s, team_skill ts  "
        		+ "WHERE e.team_id = t.id and ts.skill_id = s.id and ts.team_id = t.id and t.company_id = ? "
        		+ "HAVING e.email != t.leader_email and t.id = ?;";
    	
        String UPDATE_USERS_SQL = "UPDATE team SET name = ?, leader_email = ?"
        		+ "WHERE id  = ?";
    	
    	String INSERT_SKILL_SQL = "INSERT INTO team_skill" +
                "  (team_id, skill_id) VALUES "
                + " (?, ?);";
    	
    	String SELECT_TEAMname = "SELECT name FROM team";
       
 
        
        int result = 0;
        int companie = 0;
        Integer id_emp = 0;
        Integer id_skill = 0;

        
        
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
            }
            

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        try {
            
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEAM_SQL);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, team.getNumeEchipa());
            preparedStatement.setString(2, team.getLiderEchipa());
            preparedStatement.setInt(3, companie);
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        
                
//        try {
//                // Step 2:Create a statement using connection object
//                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SKILL_SQL);
//                preparedStatement.setString(1, employee.getSkill());
//                preparedStatement.setInt(2, companie);
//     
//                System.out.println(preparedStatement);
//                // Step 3: Execute the query or update query
//                result = preparedStatement.executeUpdate();
//           
//     
//            } catch (SQLException e) {
//                // process sql exception
//                printSQLException(e);
//            }
//        
//        
//
//        try {
//                
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
//            //preparedStatement.setInt(1, 1);
//            preparedStatement.setString(1, employee.getLastName());
//            preparedStatement.setString(2, employee.getFirstName());
//            preparedStatement.setString(3, employee.getBirthDate());
//            preparedStatement.setString(4, employee.getSex());
//            preparedStatement.setString(5, employee.getPhone());
//            preparedStatement.setString(6, employee.getEmail());
//            preparedStatement.setInt(7, companie);
//            preparedStatement.setString(8, employee.getJob());
//            preparedStatement.setString(9, employee.getTeam());
//            preparedStatement.setString(10, "employee");
//            preparedStatement.setString(11, password);
// 
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            result = preparedStatement.executeUpdate();
//            
////            SendEmail email = new SendEmail();
////            System.out.println("EMAIL: " + email);
//            
//            
//        } catch (SQLException e) {
//            // process sql exception
//            printSQLException(e);
//        }
//        
//        
//        
//        try {
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_EMPid);
//            //preparedStatement2.setInt(1, 1);
//            preparedStatement2.setString(1, employee.getEmail());
//            preparedStatement2.setString(2, password);
// 
//            System.out.println(preparedStatement2);
//            // Step 3: Execute the query or update query
//            ResultSet result1 = preparedStatement2.executeQuery();
//            if (result1.next()) {
//                id_emp = result1.getInt(1);
//            };
//            
//            System.out.println("ID_EMP: " + id_emp);
//       
//
//            } catch (SQLException e) {
//                // process sql exception
//                printSQLException(e);
//            }
//        
//        
//        try {
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_SKILLid);
//            //preparedStatement2.setInt(1, 1);
//            preparedStatement2.setString(1, employee.getSkill());
//            preparedStatement2.setInt(2, companie);
// 
//            System.out.println(preparedStatement2);
//            // Step 3: Execute the query or update query
//            ResultSet result1 = preparedStatement2.executeQuery();
//            if (result1.next()) {
//                id_skill = result1.getInt(1);
//            }
//       
//
//            } catch (SQLException e) {
//                // process sql exception
//                printSQLException(e);
//            }
//        
//        
//        try {
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SKILL_SQL);
//            preparedStatement.setInt(1, id_emp);
//            preparedStatement.setInt(2, id_skill);
// 
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            result = preparedStatement.executeUpdate();
//       
// 
//        } catch (SQLException e) {
//            // process sql exception
//            printSQLException(e);
//        }
        
        
        

        List<String> echipe = new ArrayList<String>();
        
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEAMname);
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet result2 = preparedStatement.executeQuery();
            while(result2.next())
            {
            	echipe.add(result2.getString(1));
            }
            
            System.out.println("ECHIPE: " + echipe);
            
            
 
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


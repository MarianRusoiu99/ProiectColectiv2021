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


 
public class AddTeamDao {
	
	
    public int addTeam (AddTeamBean team) throws ClassNotFoundException {
        
    	String SELECT_QUERY = "SELECT company_id FROM employee WHERE id = ?";
    	
        String INSERT_TEAM_SQL = "INSERT INTO team" +
                "  (name, leader_email, company_id) VALUES " +
                " (?, ?, ?);";
    	
    	String SELECT_TEAMid = "SELECT id FROM team WHERE leader_email = ? and company_id = ?";
    	
    	String SELECT_SKILLid = "SELECT id FROM skill WHERE name = ? and company_id = ?";
    	
    	String INSERT_TEAMskill_SQL = "INSERT INTO team_skill" +
                "  (team_id, skill_id) VALUES "
                + " (?, ?);";
    	
    	String UPDATE_TEAMemp = "UPDATE employee SET team_id = ? WHERE email = ?";

    	
    	
 
        
        int result = 0;
        int companie = 0;
        Integer id_team = 0;
        Integer id_skill = 0;

        
        
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
        
                
        try {
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEAMid);
                preparedStatement.setString(1, team.getLiderEchipa());
                preparedStatement.setInt(2, companie);
     
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet result2 = preparedStatement.executeQuery();
                if (result2.next()) {
                    id_team = result2.getInt(1);
                }
                
           
     
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SKILLid);
            preparedStatement.setString(1, team.getSkillEchipa());
            preparedStatement.setInt(2, companie);
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet result2 = preparedStatement.executeQuery();
            if (result2.next()) {
                id_skill = result2.getInt(1);
            }
            
            
 
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        
        

        try {
                
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEAMskill_SQL);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setInt(1, id_team);
            preparedStatement.setInt(2, id_skill);
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            

            
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        
        
        
        try {
            
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TEAMemp);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setInt(1, id_team);
            preparedStatement.setString(2, team.getLiderEchipa());
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            

            
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        
        
        try {
            
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TEAMemp);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setInt(1, id_team);
            preparedStatement.setString(2, team.getMembruEchipa());
 
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


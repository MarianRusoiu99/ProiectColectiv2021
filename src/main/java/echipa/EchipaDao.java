package echipa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.LoginServlet;
import mail.SendEmail;
import passwordGenerator.PasswordGenerator;
import profile.ProfileBean;



 
public class EchipaDao {
	
	
	public static EchipaBean viewTeam () throws ClassNotFoundException {
        
    	String SELECT_QUERY = "SELECT company_id FROM employee WHERE id = ?";
    	
    	String SELECT_LEADER = "SELECT e.id, e.last_name, e.first_name, e.job, e.email, e.phone, t.id FROM employee e, team t WHERE e.email = t.leader_email and e.company_id = ?;";
    	
    	String SELECT_EMPs = "SELECT e.id, e.last_name, e.first_name, e.job, e.email, e.phone FROM employee e, team t WHERE e.company_id = ? and e.team_id = ? and e.email != t.leader_email";
    	
    	String SELECT_TEAMs = "SELECT name, leader_email FROM team WHERE company_id = ? and id = ?";
    	
    	EchipaBean echipa = new EchipaBean();
    	
        int result = 0;
        int companie = 0;
        Integer id_emp = 0;
        Integer id_lider = 0;
        Integer team_id = 0;
        String numeEchipa = null;
        String emailLider = null;
        String liderEmail = null;
        String pozitieMembru = null;
        String numeMembru = null;
        String prenumeMembru = null;
        String jobMembru = null;
        String disponibilitate = null;
        String emailMembru = null;
        String telefonMembru = null;
        
        
        String numeLider = null;
        String prenumeLider = null;
        String jobLider = null;
        String telefonLider = null;
        
        
        
        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .useLower(true)
                .useUpper(true)
                .build();
        String password = passwordGenerator.generate(8);
        
        
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
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_LEADER);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(1, companie);
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
                id_lider = result1.getInt(1);
                System.out.println("ID_LIDER: " + id_lider);
                numeLider = result1.getString(2);
                System.out.println("NUME LIDER: " + numeLider);
                prenumeLider = result1.getString(3);
                System.out.println("PRENUME LIDER: " + prenumeLider);
                jobLider = result1.getString(4);
                System.out.println("JOB LIDER: " + jobLider);
                emailLider = result1.getString(5);
                System.out.println("EMAIL LIDER: " + emailLider);
                telefonLider = result1.getString(6);
                System.out.println("TELEFON LIDER: " + telefonLider);
                team_id = result1.getInt(7);
                System.out.println("TEAM ID: " + team_id);
                
                
                echipa.setNumeLider(numeLider);
                echipa.setPrenumeLider(prenumeLider);
                echipa.setJobLider(jobLider);
                echipa.setEmailLider(emailLider);
                echipa.setTelefonLider(telefonLider);
                echipa.setPozitieLider("Team leader");
                
            }
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_EMPs);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(1, companie);
            preparedStatement2.setInt(2, team_id);

            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
                id_emp = result1.getInt(1);
                System.out.println("ID_EMP: " + id_emp);
                numeMembru = result1.getString(2);
                System.out.println("NUME MEMBRU: " + numeMembru);
                prenumeMembru = result1.getString(3);
                System.out.println("PRENUME MEMBRU: " + prenumeMembru);
                jobMembru = result1.getString(4);
                System.out.println("JOB MEMBRU: " + jobMembru);
                emailMembru = result1.getString(5);
                System.out.println("EMAIL MEMBRU: " + emailMembru);
                telefonMembru = result1.getString(6);
                System.out.println("TELEFON MEMBRU: " + telefonMembru);
                
                
                echipa.setNumeMembru(numeMembru);
                echipa.setPrenumeMembru(prenumeMembru);
                echipa.setJobMembru(jobMembru);
                echipa.setEmailMembru(emailMembru);
                echipa.setTelefonMembru(telefonMembru);
                echipa.setPozitieMembru("Member");
                
            }
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_TEAMs);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(1, companie);
            preparedStatement2.setInt(2, team_id);
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
                numeEchipa = result1.getString(1);
                liderEmail = result1.getString(2);

                
                echipa.setNumeEchipa(numeEchipa);
                System.out.println("NUME ECHIPA " + numeEchipa);
                echipa.setEmailLider(liderEmail);
                System.out.println("EMAIL LIDER " + liderEmail);
                
            }
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }

        
        return echipa;
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

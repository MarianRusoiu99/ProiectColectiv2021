package echipa;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import login.LoginServlet;
import passwordGenerator.PasswordGenerator;
 
 
 
 
public class EchipaDao {
    
    
    public static List<EchipaBean> viewTeam () throws ClassNotFoundException {
        
        String SELECT_QUERY = "SELECT company_id FROM employee WHERE id = ?";
        
        String SELECT_TEAMid = "SELECT t.id, t.name, t.leader_email FROM team t, employee e WHERE e.id = ? and e.company_id = ? and t.id = e.team_id;";
        
        String SELECT_TEAM = "SELECT id, last_name, first_name, job, email, phone FROM employee WHERE team_id = ?;";
        
        
        
        
        List<EchipaBean> echipa = new ArrayList<EchipaBean>();
        
        
        
        int companie = 0;
        Integer id_team = 0;
        Integer id_emp = 0;
        String numeEchipa = null;
        String emailLider = null;
        String numeMembru = null;
        String prenumeMembru = null;
        String jobMembru = null;
        String emailMembru = null;
        String telefonMembru = null;
        
        
        
        Class.forName("com.mysql.jdbc.Driver");
        
        
        Connection connection = null;
        try {
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/task-manager", "root", "admin");
                
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        
        
        try {
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_QUERY);
            preparedStatement2.setInt(1, LoginServlet.userID);
 
            System.out.println(preparedStatement2);
            
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
                companie = result1.getInt(1);
            }
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        
        try {
        	
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_TEAMid);

            preparedStatement2.setInt(1, LoginServlet.userID);
            preparedStatement2.setInt(2, companie);
 
            System.out.println(preparedStatement2);

            
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
                id_team = result1.getInt(1);
                numeEchipa = result1.getString(2);
               System.out.println("NUME ECHIPA: " + numeEchipa);
                emailLider = result1.getString(3);
                
                
                
            }
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        if(id_team != 0) {
 
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_TEAM);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(1, id_team);
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            
            ResultSet result1 = preparedStatement2.executeQuery();
            while (result1.next()) {
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
                
                EchipaBean membru = new EchipaBean();
                
                membru.setNumeEchipa(numeEchipa);
                membru.setNumeMembru(numeMembru);
                membru.setPrenumeMembru(prenumeMembru);
                membru.setJobMembru(jobMembru);
                membru.setEmailMembru(emailMembru);
                membru.setTelefonMembru(telefonMembru);
                membru.setId_team(id_team);
                
                if(emailLider.equals(emailMembru))
                    membru.setPozitieMembru("Leader");
                else membru.setPozitieMembru("Member");
                
                echipa.add(membru);
                System.out.println("!!! " + echipa.get(0).getNumeMembru());
                
            }
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        } else {
            
            //EchipaServlet.infoBox("YOUR INFORMATION HERE", "TITLE BAR MESSAGE");
            
            System.out.println(" --------- Utilizatorul nu face parte din vreo echipa -----------");
            
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
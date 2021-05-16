package employeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.LoginServlet;

public class EditEmployeeDao {

public int editEmployee (AddEmployeeBean employee) throws ClassNotFoundException {
        
		String SELECT_QUERY = "SELECT company_id FROM employee WHERE id = ?";
	
    	String SELECT_EMPLOYEE = "SELECT e.id, e.last_name, e.first_name, e.birth_date, e.sex, e.job, s.name as skill, e.email, e.phone "
    			+ "FROM employee e, skill s, employee_skill es "
    			+ "WHERE s.id = es.skill_id and e.id = es.employee_id and company_id = ?;";    

        String UPDATE_USERS_SQL = "UPDATE employee SET last_name = ?, first_name = ?, birth_date = ?, sex = ?, phone = ?, email = ?, job = ?"
        		+ "WHERE id  = ?";
        
        //select pe skill-uri
        
        String SELECT_SKILLS = "SELECT id FROM skill WHERE name = ? and company_id = ?";
        
        String INSERT_SKILL_SQL = "INSERT INTO skill" +       // pentru adaugare skill nou, cand se face update si skill-ul nu exista
                "  (name, company_id) VALUES "
                + " (?, ?);";
    	
    	String SELECT_SKILLid = "SELECT id FROM skill WHERE name = ? and company_id = ?";
    	
        String UPDATE_EMPLOYEE_SKILL_SQL = "UPDATE employee_skill SET skill_id = ? WHERE employee_id = ?"; //insert

        int result = 0;
 
        int companie = 0;
        int id_emp = 0;
        int id_skill = 0;
        String lastName = null;
        String firstName = null;
        String birthDate = null;
        String sex = null;
        String job = null;
        String email = null;
        String phone = null;
        String skillName = null;
        
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
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_EMPLOYEE);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(1, companie);
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
                id_emp = result1.getInt(1);
                lastName = result1.getString(2);
                firstName = result1.getString(3);
                birthDate = result1.getString(4);
                sex = result1.getString(5);
                job = result1.getString(6);
                skillName = result1.getString(7).toLowerCase();
                email = result1.getString(8);
                phone = result1.getString(9);
            }
       
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
 
 
        try {
                
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, employee.getLastName());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getBirthDate());
            preparedStatement.setString(4, employee.getSex());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getJob());
            preparedStatement.setInt(8, id_emp);
            
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_SKILLS);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setString(1, skillName.toLowerCase());
            preparedStatement2.setInt(1, companie);
 
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
        
        if(id_skill == 0) {
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SKILL_SQL);
            preparedStatement.setString(1, employee.getSkill());
            preparedStatement.setInt(2, companie);
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
       
 
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_SKILLid);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setString(1, skillName.toLowerCase());
            preparedStatement2.setInt(2, companie);
 
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
        }
        
        try {
            
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SKILL_SQL);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setInt(1, id_skill);
            preparedStatement.setInt(2, id_emp);

            
 
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

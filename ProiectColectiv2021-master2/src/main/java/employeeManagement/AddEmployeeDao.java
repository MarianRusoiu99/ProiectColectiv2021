package employeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.LoginServlet;

 
public class AddEmployeeDao {
 
    public int addEmployee (AddEmployeeBean employee) throws ClassNotFoundException {
        
    	String SELECT_QUERY = "SELECT company_id FROM employee WHERE id = ?";    		// selecteaza id-ul companiei
    																			// apoi insereaza un skill (al companiei - e unic) - skill
    	String INSERT_SKILL_SQL = "INSERT INTO skill" +                   		// selecteaza id-ul angajatului
                "  (name, company_id) VALUES " 									// selecteaza id-ul skill-ului
                + " (?, ?);";													// apoi insereaza un skill (al angajatului) - employee_skill
    																			// la final adaug agajatul - employee
    	
        String INSERT_USERS_SQL = "INSERT INTO employee" +
                "  (last_name, first_name, birth_date, sex, phone, email, company_id, job, team_id, user_type, password) VALUES " +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, md5(?));";
    	
    	String SELECT_EMPid = "SELECT id FROM employee WHERE email = ? and password = ?";
    	
    	String SELECT_SKILLid = "SELECT id FROM skill WHERE name = ? and company_id = ?";
    	
        String INSERT_EMPLOYEE_SKILL_SQL = "INSERT INTO employee_skill" +
                "  (employee_id, skill_id) VALUES " 
                + " (?, ?);";
       
 
        
        int result = 0;
        int companie = 0;
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
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_QUERY);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setString(1, employee.getCompany());
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            result = preparedStatement2.executeUpdate();
       
 
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        try {
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SKILL_SQL);
                preparedStatement.setString(1, skill);
                preparedStatement.setInt(2, result);
     
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet result1 = preparedStatement.executeQuery();
                if (result1.next()) {
                    //skill = ??
                }
           
     
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_EMPid);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setInt(1, companie);
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            result = preparedStatement2.executeUpdate();
       

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SKILL_SQL);
            preparedStatement.setString(1, skill);
            preparedStatement.setString(2, employee.getCompany());
 
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
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            //preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, employee.getLastName());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getBirthDate());
            preparedStatement.setString(4, employee.getSex());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setInt(7, companie);
            preparedStatement.setString(8, employee.getJob());
            preparedStatement.setString(9, employee.getTeam());
            preparedStatement.setString(10, "employee");
            preparedStatement.setString(11, employee.getPassword());
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    
    
//    public Integer validate(AddEmployeeBean employee) throws ClassNotFoundException {
//        boolean status = false;
//        //int statusint = 0;
//        Integer id=0;
//        
//        Class.forName("com.mysql.jdbc.Driver");
// 
//        try (Connection connection = DriverManager
//                .getConnection("jdbc:mysql://localhost:3307/task-manager", "root", "admin");
// 
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement("select id from employee where email = ? and password = ? ")) {
//            preparedStatement.setString(1, employee.getEmail());
//            preparedStatement.setString(2, employee.getPassword());
// 
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//            //int id = rs
//            //id = rs.getInt("id");
//            status = rs.next();
//            if(status==true)
//            	id = rs.getInt("id");
//
//        } catch (SQLException e) {
//            // process sql exception
//            printSQLException(e);
//        }
//        return id;
//    }
 
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

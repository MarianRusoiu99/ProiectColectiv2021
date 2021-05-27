package registration;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
 
public class EmployeeDao {
 
    public int registerEmployee(EmployeeBean employee) throws ClassNotFoundException {
        
        String INSERT_COMPANY_SQL = "INSERT INTO company" +
                "  (name) VALUES " + " (?);";
     
        String SELECT_QUERY = "SELECT id FROM company WHERE name = ?";
        
        String INSERT_USERS_SQL = "INSERT INTO employee" +
            "  (last_name, first_name, birth_date, sex, phone, email, company_id, job, user_type, password) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        //String DELETE_COMPANY_SQL = "DELETE FROM company WHERE id = ?";
 
        int result = 0;
 
        int companie = 0;
        
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
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMPANY_SQL);
                preparedStatement.setString(1, employee.getCompany());
     
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                result = preparedStatement.executeUpdate();
           
                //System.out.println("RESULT COMPANY: " + result);
     
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        try {
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_QUERY);
            //preparedStatement2.setInt(1, 1);
            preparedStatement2.setString(1, employee.getCompany());
 
            System.out.println(preparedStatement2);
            // Step 3: Execute the query or update query
            ResultSet result1 = preparedStatement2.executeQuery();
            if (result1.next()) {
                companie = result1.getInt(1);
            }
       
            //System.out.println("RESULT1: " + result1);
 
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
            preparedStatement.setString(9, "admin");
            preparedStatement.setString(10, employee.getPassword());
 
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            //System.out.println("RESULT: " + result);
 
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
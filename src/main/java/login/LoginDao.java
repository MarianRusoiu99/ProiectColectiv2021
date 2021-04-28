package login;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
 
public class LoginDao {
 
    public Integer validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;
        //int statusint = 0;
        Integer id=0;
        
        Class.forName("com.mysql.jdbc.Driver");
 
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3307/task-manager", "root", "admin");
 
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement("select id from employee where email = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getEmail());
            preparedStatement.setString(2, loginBean.getPassword());
 
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            //int id = rs
            //id = rs.getInt("id");
            status = rs.next();
            if(status==true)
            	id = rs.getInt("id");
 
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return id;
    }
 
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
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
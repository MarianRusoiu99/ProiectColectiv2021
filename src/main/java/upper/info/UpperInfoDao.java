package upper.info;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
import login.LoginBean;
import login.LoginServlet;
 
public class UpperInfoDao {
 
	public static void info(Integer id) throws ClassNotFoundException {
        boolean status = false;
        //int statusint = 0;
        String last_name = "";
        String first_name = "";
        String job = "";
        String user_type = "";
        String name = "";
        String company="";
        UpperInfoBean o = new UpperInfoBean();
        //String company_name = "";
        //ArrayList<String> data = new ArrayList<String>();
 
        Class.forName("com.mysql.jdbc.Driver");
 
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3307/task-manager", "root", "root");
 
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                        .prepareStatement("select e.id, e.last_name, e.first_name, e.job, e.user_type,c.name from employee e, company c where e.company_id=c.id having e.id = ? ")) {
            preparedStatement.setInt(1, id);
 
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            //int id = rs
            //id = rs.getInt("id");
            status = rs.next();
            if(status==true)
            {
            	last_name = rs.getString("e.last_name");
            	first_name = rs.getString("e.first_name");
            	name = last_name + " " + first_name;
            	job = rs.getString("e.job");
            	user_type = rs.getString("e.user_type");
            	company=rs.getString("c.name");
            	o.setNume(name);
            	o.setJob(job);
            	o.setTip_user(user_type);
            	o.setCompanie(company);
            	//UpperInfoBean.setJob(job);
            	//UpperInfoBean.setTip_user(user_type);
            	System.out.println("userID: " + LoginServlet.userID);
            }
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
    }
 
    private static void printSQLException(SQLException ex) {
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

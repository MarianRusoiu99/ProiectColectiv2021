package registration;
 
import java.io.Serializable;
 
/**
 * JavaBean class used in jsp action tags.
 * @author
 */
public class EmployeeBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String lastName;
    private String firstName;
    private String birthDate;   // sau Date
    private String sex;
    private String phone;
    private String email;
    private String company;     // sau Int
    private String job;
    private String password;
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getBirthDate() {
        return birthDate;
    }
    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
    
    
}
package profile;

import java.io.Serializable;

public class ProfileBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String lastName;
	private static String firstName;
	private static String job;
	private static String sex;
	private static String birthDate;
	private static String teamLeader;  // Da (+ numele echipei) / Nu
	private static String team;      // numele echipei
	private static String email;
	private static String phone;
	
	
	public static String getLastName() {
		return lastName;
	}
	public static void setLastName(String lastName) {
		ProfileBean.lastName = lastName;
	}
	public static String getFirstName() {
		return firstName;
	}
	public static void setFirstName(String firstName) {
		ProfileBean.firstName = firstName;
	}
	public static String getJob() {
		return job;
	}
	public static void setJob(String job) {
		ProfileBean.job = job;
	}
	public static String getSex() {
		return sex;
	}
	public static void setSex(String sex) {
		ProfileBean.sex = sex;
	}
	public static String getBirthDate() {
		return birthDate;
	}
	public static void setBirthDate(String birthDate) {
		ProfileBean.birthDate = birthDate;
	}
	public static String getTeamLeader() {
		return teamLeader;
	}
	public static void setTeamLeader(String teamLeader) {
		ProfileBean.teamLeader = teamLeader;
	}
	public static String getTeam() {
		return team;
	}
	public static void setTeam(String team) {
		ProfileBean.team = team;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		ProfileBean.email = email;
	}
	public static String getPhone() {
		return phone;
	}
	public static void setPhone(String phone) {
		ProfileBean.phone = phone;
	}
	
	
	
	
}

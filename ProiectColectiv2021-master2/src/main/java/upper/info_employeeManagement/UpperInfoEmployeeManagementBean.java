package upper.info_employeeManagement;

import java.io.Serializable;

public class UpperInfoEmployeeManagementBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String nume;
	private static String job;
	private static String tip_user;
	private static String companie;
	
	public static String getNume() {
		return nume;
	}
	public static void setNume(String nume) {
		UpperInfoEmployeeManagementBean.nume = nume;
	}
	public static String getJob() {
		return job;
	}
	public static void setJob(String job) {
		UpperInfoEmployeeManagementBean.job = job;
	}
	public static String getTip_user() {
		return tip_user;
	}
	public static void setTip_user(String tip_user) {
		UpperInfoEmployeeManagementBean.tip_user = tip_user;
	}
	public static String getCompanie() {
		return companie;
	}
	public static void setCompanie(String companie) {
		UpperInfoEmployeeManagementBean.companie = companie;
	}
}

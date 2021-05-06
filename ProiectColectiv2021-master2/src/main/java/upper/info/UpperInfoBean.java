package upper.info;

import java.io.Serializable;

public class UpperInfoBean implements Serializable {

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
		UpperInfoBean.nume = nume;
	}
	public static String getJob() {
		return job;
	}
	public static void setJob(String job) {
		UpperInfoBean.job = job;
	}
	public static String getTip_user() {
		return tip_user;
	}
	public static void setTip_user(String tip_user) {
		UpperInfoBean.tip_user = tip_user;
	}
	public static String getCompanie() {
		return companie;
	}
	public static void setCompanie(String companie) {
		UpperInfoBean.companie = companie;
	}
}

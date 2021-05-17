package teamManagement;

import java.io.Serializable;

public class AddTeamBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeEchipa;
	private String liderEchipa;
	private String membruEchipa;
	private String skillEchipa;
	
	
	
	
	public AddTeamBean(String numeEchipa, String liderEchipa, String membruEchipa, String skillEchipa) {
		super();
		this.numeEchipa = numeEchipa;
		this.liderEchipa = liderEchipa;
		this.membruEchipa = membruEchipa;
		this.skillEchipa = skillEchipa;
	}
	
	public AddTeamBean() {
		super();
	}

	public String getNumeEchipa() {
		return numeEchipa;
	}
	public void setNumeEchipa(String numeEchipa) {
		this.numeEchipa = numeEchipa;
	}
	public String getLiderEchipa() {
		return liderEchipa;
	}
	public void setLiderEchipa(String liderEchipa) {
		this.liderEchipa = liderEchipa;
	}
	public String getMembruEchipa() {
		return membruEchipa;
	}
	public void setMembruEchipa(String membruEchipa) {
		this.membruEchipa = membruEchipa;
	}
	public String getSkillEchipa() {
		return skillEchipa;
	}
	public void setSkillEchipa(String skillEchipa) {
		this.skillEchipa = skillEchipa;
	}
	
	
	
	
}

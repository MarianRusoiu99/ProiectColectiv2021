package teamsManagement;

import java.io.Serializable;
import java.util.List;

public class AddTeamBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeEchipa;
	private String liderEchipa;
	private String membruEchipa;
	private String skillEchipa;
	private List<String> skills;
	private List<String> membrii;
	
	
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public List<String> getMembrii() {
		return membrii;
	}
	public void setMembrii(List<String> membrii) {
		this.membrii = membrii;
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

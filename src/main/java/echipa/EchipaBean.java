package echipa;

import java.io.Serializable;

public class EchipaBean implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public String pozitieMembru;
	public String numeMembru;
	public String prenumeMembru;
	public String jobMembru;
	public String disponibilitate;
	public String emailMembru;
	public String telefonMembru;
	public String numeEchipa;
	public String emailLider;
	public int id_team;



	public int getId_team() {
		return id_team;
	}
	public void setId_team(int id_team) {
		this.id_team = id_team;
	}
	public String getNumeEchipa() {
		return numeEchipa;
	}
	public void setNumeEchipa(String numeEchipa) {
		this.numeEchipa = numeEchipa;
	}
	public String getEmailLider() {
		return emailLider;
	}
	public void setEmailLider(String emailLider) {
		this.emailLider = emailLider;
	}
	public String getPozitieMembru() {
		return pozitieMembru;
	}
	public void setPozitieMembru(String pozitieMembru) {
		this.pozitieMembru = pozitieMembru;
	}
	public String getNumeMembru() {
		return numeMembru;
	}
	public void setNumeMembru(String numeMembru) {
		this.numeMembru = numeMembru;
	}
	public String getPrenumeMembru() {
		return prenumeMembru;
	}
	public void setPrenumeMembru(String prenumeMembru) {
		this.prenumeMembru = prenumeMembru;
	}
	public String getJobMembru() {
		return jobMembru;
	}
	public void setJobMembru(String jobMembru) {
		this.jobMembru = jobMembru;
	}
	public String getDisponibilitate() {
		return disponibilitate;
	}
	public void setDisponibilitate(String disponibilitate) {
		this.disponibilitate = disponibilitate;
	}
	public String getEmailMembru() {
		return emailMembru;
	}
	public void setEmailMembru(String emailMembru) {
		this.emailMembru = emailMembru;
	}
	public String getTelefonMembru() {
		return telefonMembru;
	}
	public void setTelefonMembru(String telefonMembru) {
		this.telefonMembru = telefonMembru;
	}
	
}

package taskManagement;

import java.io.Serializable;

public class AddTaskBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeTask;
	private String descriereTask;
	private String tehnologiiTask;
	private String deadlineTask;
	private String tipTask;
	private String repetitive;
	private String slaTask;
	private String status;
	private String contactEmail;
	
	
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getRepetitive() {
		return repetitive;
	}
	public void setRepetitive(String repetitive) {
		this.repetitive = repetitive;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNumeTask() {
		return numeTask;
	}
	public void setNumeTask(String numeTask) {
		this.numeTask = numeTask;
	}
	public String getDescriereTask() {
		return descriereTask;
	}
	public void setDescriereTask(String descriereTask) {
		this.descriereTask = descriereTask;
	}
	public String getTehnologiiTask() {
		return tehnologiiTask;
	}
	public void setTehnologiiTask(String tehnologiiTask) {
		this.tehnologiiTask = tehnologiiTask;
	}
	public String getDeadlineTask() {
		return deadlineTask;
	}
	public void setDeadlineTask(String deadlineTask) {
		this.deadlineTask = deadlineTask;
	}
	public String getTipTask() {
		return tipTask;
	}
	public void setTipTask(String tipTask) {
		this.tipTask = tipTask;
	}
	public String getSlaTask() {
		return slaTask;
	}
	public void setSlaTask(String slaTask) {
		this.slaTask = slaTask;
	}
	
	
	
	


}

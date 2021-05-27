package taskSuplim;

import java.io.Serializable;

public class TaskSuplimBean implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public int idTask;
	public String numeTask;
	public String descriereTask;
	public String tehnologiiTask;
	public String deadlineTask;
	public String repetitiveTask;
	public String contactTask;
	public String tipTask;
	
	
	public int getIdTask() {
		return idTask;
	}
	public void setIdTask(int idTask) {
		this.idTask = idTask;
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
	public String getRepetitiveTask() {
		return repetitiveTask;
	}
	public void setRepetitiveTask(String repetitiveTask) {
		this.repetitiveTask = repetitiveTask;
	}
	public String getContactTask() {
		return contactTask;
	}
	public void setContactTask(String contactTask) {
		this.contactTask = contactTask;
	}
	public String getTipTask() {
		return tipTask;
	}
	public void setTipTask(String tipTask) {
		this.tipTask = tipTask;
	}

	
}
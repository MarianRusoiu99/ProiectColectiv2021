package Model;

import java.io.Serializable;

public class Task implements Serializable {
    
	
	
    private static final long serialVersionUID = 1L;
    
    
    private String task_name;
    private String task_description;
    private String task_req;   
    private String task_deadline;
    private String task_type;
    private String task_repetition ;
    private String task_sla;
    
    public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getTask_description() {
		return task_description;
	}
	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}
	public String getTask_req() {
		return task_req;
	}
	public void setTask_req(String task_req) {
		this.task_req = task_req;
	}
	public String getTask_deadline() {
		return task_deadline;
	}
	public void setTask_deadline(String task_deadline) {
		this.task_deadline = task_deadline;
	}
	public String getTask_type() {
		return task_type;
	}
	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}
	public String getTask_repetition() {
		return task_repetition;
	}
	public void setTask_repetition(String task_repetition) {
		this.task_repetition = task_repetition;
	}
	public String getTask_sla() {
		return task_sla;
	}
	public void setTask_sla(String task_sla) {
		this.task_sla = task_sla;
	}
	     
    
    
}
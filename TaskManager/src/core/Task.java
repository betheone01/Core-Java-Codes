package core;

import java.time.LocalDate;

public class Task {

	private  int taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private Status status;
	private  boolean active;
	
	
	private static int idGenerator;
	static {
		idGenerator=0;
	}
	public Task( String taskName, String description, LocalDate taskDate) {
		super();
		
		this.taskId = ++idGenerator;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status=Status.PENDING;
		this.active=true;
	}
	
	// pk 
	public Task(String taskname)
	{
		this.taskName=taskname;
	}
	public int getTaskId(int taskId)
	{
		return this.taskId;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description + ", taskDate="
				+ taskDate + ", status=" + status + ", active=" + active + "]";
	}
	
	public int getTaskId() {
		return taskId;
	}



	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}



	public String getTaskName() {
		return taskName;
	}



	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public LocalDate getTaskDate() {
		return taskDate;
	}



	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	
	
	
	
}

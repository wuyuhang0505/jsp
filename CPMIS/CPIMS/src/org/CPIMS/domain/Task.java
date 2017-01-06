package org.CPIMS.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskId;
	
	@Column
	private String taskNum;
	
	@Column
	private String taskName;
	
	@Column
	private Long sourcedepartmentId;
	
	@Column
	private Long destdepartmentId;
	
	@Column
	private Long sourcepostId;
	
	@Column
	private Long destpostId;
	
	@Column
	private String context;
    
	@Column
	private Date taskStarTime;
	
	@Column
	private Boolean taskCompleted;
	
	@Column
	private Long taskLimit;
	
	@Column
	private Long employeeId;
	
	@Column
	private Long tasktakerId;
	
	
	public Long getTaskId(){
		return taskId;
	}
	
	public void setTaskId(Long taskId){
		this.taskId=taskId;
	}
	
	public String getTaskNum(){
		return taskNum;
	}
	
	public void setTaskNum(String taskNum){
		this.taskNum=taskNum;
	}
	
	public String getTaskName(){
		return taskName;
	}
	
	public void setTaskName(String taskName){
		this.taskName=taskName;
	}
	
	public String getContext(){
		return context;
	}
	
	public void setContext(String context){
		this.context=context;
	}
	
	public Date getTaskStarTime(){
		return taskStarTime;
	}
	
	public void setTaskStarTime(Date taskStarTime){
		this.taskStarTime=taskStarTime;
	}
	
	public Long getTaskLimit(){
		return taskLimit;
	}
	
	public void setTaskLimit(Long taskLimit){
		this.taskLimit=taskLimit;
	}
	
	public boolean getTaskCompleted(){
		return taskCompleted;
	}
	
	public void setTaskCompleted(Boolean Completed){
		this.taskCompleted=Completed;
	}
	
	public Long getTasktakerId(){
		return tasktakerId;
	}
	
	public void setTasktakerId(Long tasktakerId){
		this.tasktakerId=tasktakerId;
	}

	public Long getSourcedepartmentId() {
		return sourcedepartmentId;
	}

	public void setSourcedepartmentId(Long sourcedepartmentId) {
		this.sourcedepartmentId = sourcedepartmentId;
	}

	public Long getDestdepartmentId() {
		return destdepartmentId;
	}

	public void setDestdepartmentId(Long destdepartmentId) {
		this.destdepartmentId = destdepartmentId;
	}

	public Long getSourcepostId() {
		return sourcepostId;
	}

	public void setSourcepostId(Long sourcepostId) {
		this.sourcepostId = sourcepostId;
	}

	public Long getDestpostId() {
		return destpostId;
	}

	public void setDestpostId(Long destpostId) {
		this.destpostId = destpostId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}

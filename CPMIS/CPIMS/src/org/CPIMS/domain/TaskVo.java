package org.CPIMS.domain;

import java.sql.Date;

public class TaskVo {

	private Long taskId;
	private String taskNum;
	private String taskName;
	private Long sourcedepartmentId;
	private String sourcedepartmentName;
	private Long destdepartmentId;
	private String destdepartmentName;
	private Long sourcepostId;
	private String sourcepostName;
	private Long destpostId;
	private String destpostName;
	private String context;
	private Date taskStarTime;
	private Boolean taskCompleted;
	private Long taskLimit;
	private Long employeeId;
	private String sourceemployeeNum;
	private String sourceemployeeName;
	private String destemployeeName;
	private String destemployeeNum;
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

	public Long getEemployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long sourceemployeeId) {
		this.employeeId = sourceemployeeId;
	}

	public String getSourcedepartmentName() {
		return sourcedepartmentName;
	}

	public void setSourcedepartmentName(String sourcedepartmentName) {
		this.sourcedepartmentName = sourcedepartmentName;
	}

	public String getDestdepartmentName() {
		return destdepartmentName;
	}

	public void setDestdepartmentName(String destdepartmentName) {
		this.destdepartmentName = destdepartmentName;
	}

	public String getSourcepostName() {
		return sourcepostName;
	}

	public void setSourcepostName(String sourcepostName) {
		this.sourcepostName = sourcepostName;
	}

	public String getDestpostName() {
		return destpostName;
	}

	public void setDestpostName(String destpostName) {
		this.destpostName = destpostName;
	}

	public String getSourceemployeeName() {
		return sourceemployeeName;
	}

	public void setSourceemployeeName(String sourceemployeeName) {
		this.sourceemployeeName = sourceemployeeName;
	}

	public String getDestemployeeName() {
		return destemployeeName;
	}

	public void setDestemployeeName(String destemployeeName) {
		this.destemployeeName = destemployeeName;
	}

	public String getSourceemployeeNum() {
		return sourceemployeeNum;
	}

	public void setSourceemployeeNum(String sourceemployeeNum) {
		this.sourceemployeeNum = sourceemployeeNum;
	}

	public String getDestemployeeNum() {
		return destemployeeNum;
	}

	public void setDestemployeeNum(String destemployeeNum) {
		this.destemployeeNum = destemployeeNum;
	}
	
	
}

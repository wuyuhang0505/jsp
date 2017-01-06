package org.CPIMS.domain;

import java.sql.Date;

public class MoveVo {

	private Long moveId;
	private Long employeeId;
	private String employeeNum;
	private String employeeName;
	private Long sourcedepartmentId;	
	private String sourcedepartmentName;
	private Long destdepartmentId;
	private String destdepartmentName;
	private Date moveTime;
	private String moveReason;
	private Long sourcepostId;
	private String sourcepostName;
	private Long destpostId;
	private String destpostName;
	public Long getMoveId() {
		return moveId;
	}

	public void setMoveId(Long moveId) {
		this.moveId = moveId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getMoveTime() {
		return moveTime;
	}

	public void setMoveTime(Date moveTime) {
		this.moveTime = moveTime;
	}

	public String getMoveReason() {
		return moveReason;
	}

	public void setMoveReason(String moveReason) {
		this.moveReason = moveReason;
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

	public String getDestdepartmentName() {
	return destdepartmentName;
	}

	public void setDestdepartmentName(String destdepartmentName) {
	this.destdepartmentName = destdepartmentName;
	}

	public String getSourcedepartmentName() {
		return sourcedepartmentName;
	}

	public void setSourcedepartmentName(String sourcedepartmentName) {
		this.sourcedepartmentName = sourcedepartmentName;
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
	
}
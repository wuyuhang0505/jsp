package org.CPIMS.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "move")
public class Move {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long moveId;

	@Column
	private Long employeeId;

	@Column
	private Long sourcedepartmentId;
	
	@Column
	private Long destdepartmentId;
	
	@Column
	private String destdepartmentName;
	
	@Column
	private Date moveTime;

	@Column
	private String moveReason;

	@Column
	private Long sourcepostId;
	
	@Column
	private Long destpostId;
	
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
}
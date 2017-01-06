package org.CPIMS.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specialistapply")
public class Specialistapply {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	//这条记录的Id
	private Long specialistApplyId;
	
	@Column
	//员工Id
	private Long employeeId;
	
	@Column
	//员工名字
	private String employeeName;
	
	@Column
	//申请时间
	private Date applyTime;

	@Column
	//申请专家称号
	private String applySpecialistName;

	@Column
	//是否通过申请
	private Boolean applyPass = false;

	@Column
	//申请理由
	private String applyReason;

	public Long getSpecialistApplyId() {
		return specialistApplyId;
	}

	public void setSpecialistApplyId(Long specialistApplyId) {
		this.specialistApplyId = specialistApplyId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplySpecialistName() {
		return applySpecialistName;
	}

	public void setApplySpecialistName(String applySpecialistName) {
		this.applySpecialistName = applySpecialistName;
	}

	public Boolean getApplyPass() {
		return applyPass;
	}

	public void setApplyPass(Boolean applyPass) {
		this.applyPass = applyPass;
	}

	public String getApplyReason() {
		return applyReason;
	}

	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

	

	
}

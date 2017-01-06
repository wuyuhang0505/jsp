package org.CPIMS.domain;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="information")
public class Information {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long informId;
	
	@Column
	private Long employeeId;
	
	@Column
	private Date informTime;
	
	@Column
	private String informTitle;
	

	@Column
	private String informBody;
	
	@Column
	private String employeeName;
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public Long getInformId() {
		return informId;
	}

	public void setInformId(Long informId) {
		this.informId = informId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getInformTime() {
		return informTime;
	}

	public void setInformTime(Date informTime) {
		this.informTime = informTime;
	}

	public String getInformTitle() {
		return informTitle;
	}

	public void setInformTitle(String informTitle) {
		this.informTitle = informTitle;
	}

	public String getInformBody() {
		return informBody;
	}
	
	public void setInformBody(String informBody) {
		this.informBody = informBody;
	}

}

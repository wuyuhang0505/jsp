package org.CPIMS.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	
	@Column
	private Long employeeIdcard;
	
	@Column
	private String employeeAddress;
	
	@Column
	private String employeeNation;
	
	@Column
	private Long departmentId;
	
	@Column
	private Long postId;
	
	@Column
	private String employeeNum;
	
	@Column
	private String employeePwd;
	
	@Column
	private String employeeName;
	
	@Column
	private Integer employeeAge;
	
	@Column
	private Boolean employeeSex;
	
	@Column 
	private String employeeEdu;
	
	@Column 
	private Boolean employeeState = true;
	
	@Column
	private Integer employeeTechPost = 0;
	
	@Column
	private Date employeeContractTime;
	
	@Column
	private Integer employeeContractLength;
	
	@Column
	private Boolean isSpecialist = false;
	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getEmployeePwd() {
		return employeePwd;
	}

	public void setEmployeePwd(String employeePwd) {
		this.employeePwd = employeePwd;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Boolean getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(Boolean employeeSex) {
		this.employeeSex = employeeSex;
	}
	
	public String getEmployeeEdu() {
		return employeeEdu;
	}

	public void setEmployeeEdu(String employeeEdu) {
		this.employeeEdu = employeeEdu;
	}

	public Boolean getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeState(Boolean employeeState) {
		this.employeeState = employeeState;
	}

	public Integer getEmployeeTechPost() {
		return employeeTechPost;
	}

	public void setEmployeeTechPost(Integer employeeTechPost) {
		this.employeeTechPost = employeeTechPost;
	}

	public Date getEmployeeContractTime() {
		return employeeContractTime;
	}

	public void setEmployeeContractTime(Date employeeContractTime) {
		this.employeeContractTime = employeeContractTime;
	}

	public Integer getEmployeeContractLength() {
		return employeeContractLength;
	}

	public void setEmployeeContractLength(Integer employeeContractLength) {
		this.employeeContractLength = employeeContractLength;
	}

	public Boolean getIsSpecialist(){
		return isSpecialist;
	}
	
	public void setIsSpecialist(Boolean isSpecialist){
		this.isSpecialist = isSpecialist;
	}

	public Long getEmployeeIdcard() {
		return employeeIdcard;
	}

	public void setEmployeeIdcard(Long employeeIdcard) {
		this.employeeIdcard = employeeIdcard;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeNation() {
		return employeeNation;
	}

	public void setEmployeeNation(String employeeNation) {
		this.employeeNation = employeeNation;
	}

	public Integer getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}
	
	
}

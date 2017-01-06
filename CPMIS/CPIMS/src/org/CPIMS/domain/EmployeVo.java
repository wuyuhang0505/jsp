package org.CPIMS.domain;

import java.sql.Date;

public class EmployeVo {

private Long employeeId;
	
	private Long employeeIdcard;
	private String employeeAddress;
	private String employeeNation;
	private Long departmentId;
	private String departmentName;
	private Long postId;
	private String postName;
	private String employeeNum;
	private String employeePwd;
	private String employeeName;
	private Integer employeeAge;
	private Boolean employeeSex;
	private String employeeEdu;
	private Boolean employeeState = true;
	private Integer employeeTechPost = 0;
	private Date employeeContractTime;
	private Integer employeeContractLength;
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
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
	public Boolean getIsSpecialist() {
		return isSpecialist;
	}
	public void setIsSpecialist(Boolean isSpecialist) {
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

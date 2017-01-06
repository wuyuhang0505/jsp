package org.CPIMS.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employ")
public class Employ {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employId;
	
	@Column
	private Integer postId;
	
	@Column
	private String applicant;
	
	@Column
	private String applicantPwd;
	
	@Column
	private Date employTime;
	
	@Column
	private Integer employGrade;
	
	@Column
	private Integer interviewGrade;

	public Long getEmployId() {
		return employId;
	}

	public void setEmployId(Long employId) {
		this.employId = employId;
	}

	public Integer getpostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	
	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getApplicantPwd() {
		return applicantPwd;
	}

	public void setApplicantPwd(String applicantPwd) {
		this.applicantPwd = applicantPwd;
	}

	public Date getEmployTime() {
		return employTime;
	}

	public void setEmployTime(Date employTime) {
		this.employTime = employTime;
	}

	public Integer getEmployGrade() {
		return employGrade;
	}

	public void setEmployGrade(Integer employGrade) {
		this.employGrade = employGrade;
	}
	
	public Integer getInterviewGrade() {
		return interviewGrade;
	}

	public void setInterviewGrade(Integer interviewGrade) {
		this.interviewGrade = interviewGrade;
	}

}

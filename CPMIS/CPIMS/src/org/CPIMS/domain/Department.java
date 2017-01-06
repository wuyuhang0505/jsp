package org.CPIMS.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	
	@Column
	private String departmentName;
	
	@Column
	private String departmentNum;
	
	@Column
	private Long departmentChief;

	@Column
	private String departmentChiefNa;
	
	@Column
	private Integer departmentEmployeeCount = 0;
	
	@Column
	private Integer departmentPostCount = 0;
	
	@Column
	private Boolean departmentState = true;
	
	@Column
	private String remark;
	
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

	public String getDepartmentNum() {
		return departmentNum;
	}

	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}
	
	public Long getDepartmentChief() {
		return departmentChief;
	}

	public void setDepartmentChief(Long departmentChief) {
		this.departmentChief = departmentChief;
	}
	
	public String getDepartmentChiefNa() {
		return departmentChiefNa;
	}

	public void setDepartmentChiefNa(String departmentChiefNa) {
		this.departmentChiefNa = departmentChiefNa;
	}

	public Integer getDepartmentEmployeeCount() {
		return departmentEmployeeCount;
	}

	public void setDepartmentEmployeeCount(Integer departmentEmployeeCount) {
		this.departmentEmployeeCount = departmentEmployeeCount;
	}

	public Integer getDepartmentPostCount() {
		return departmentPostCount;
	}

	public void setDepartmentPostCount(Integer departmentPostCount) {
		this.departmentPostCount = departmentPostCount;
	}
	
	public boolean getDepartmentState() {
		return departmentState;
	}

	public void setDepartmentState(Boolean departmentstate) {
		this.departmentState = departmentstate;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

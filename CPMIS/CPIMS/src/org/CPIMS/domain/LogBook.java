package org.CPIMS.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logbook")
public class LogBook {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long logBookId;
	
	@Column
	private Long taskId;
	
	@Column
	private String logContent;
	
	@Column
	private Date logDate;

	
	
	public Long getLogBookId() {
		return logBookId;
	}

	public void setLogBookId(Long logBookId) {
		this.logBookId = logBookId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	
}

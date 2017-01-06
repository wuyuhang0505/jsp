package org.CPIMS.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long postId;

	@Column
	private Long departmentId;
	
	@Column
	private String departmentName;

	@Column
	private Integer postEmployeeCount = 0;
	
	@Column
	private String postNum;

	@Column
	private String postName;

	@Column
	private Boolean postState = true;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
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

	public Integer getPostEmployeeCount(){
		return postEmployeeCount;
	}
	
	public void setPostEmployeeCount(Integer postEmployeeCount){
		this.postEmployeeCount = postEmployeeCount;
	}
	
	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public boolean PostState() {
		return postState;
	}

	public void setpostState(Boolean postState) {
		this.postState = postState;
	}
}

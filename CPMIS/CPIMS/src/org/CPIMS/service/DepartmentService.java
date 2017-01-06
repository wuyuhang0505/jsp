package org.CPIMS.service;

import java.util.List;

import javax.transaction.Transactional;

import org.CPIMS.dao.DepartmentDao;
import org.CPIMS.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DepartmentService {
	@Autowired
	DepartmentDao departmentDao;
	
	public void addDepartment(Department d){
		departmentDao.add(d);
	}

	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	
	public String findAllNum(){
		return departmentDao.findAllNum();
	}

	public void update(Department d) {
		departmentDao.update(d);
	}
	
	public void reset(Department d){
		departmentDao.reset(d);
	}

	public Department get(Long id) {
		return departmentDao.get(id);
	}

	public Department get(String departmentNum){
		return departmentDao.get(departmentNum);
	}
	
	public void addDepartmentPostCount(Department d){
		departmentDao.addDepartmentPostCount(d);
	}
	
	public void reduceDepartmentPostCount(Department d){
		departmentDao.reduceDepartmentPostCount(d);
	}
	
	public void addDepartmentEmployeeCount(Department d){
		departmentDao.addDepartmentEmployeeCount(d);
	}
	
	public void reduceDepartmentEmployeeCount(Department d){
		departmentDao.reduceDepartmentEmployeeCount(d);
	}
	
	public void delete(Department d) {
		departmentDao.delete(d);
	}
	
	public List<Department> findPart(int size,int pageSize) {
		return departmentDao.findPart(size,pageSize);
	}
}

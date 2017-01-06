package org.CPIMS.service;

import java.util.List;
import javax.transaction.Transactional;
import org.CPIMS.dao.EmployeeDao;
import org.CPIMS.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public void addEmployee(Employee e) {
		employeeDao.add(e);
	}

	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	public void update(Employee e) {
		employeeDao.update(e);

	}

	public Employee get(Long id) {
		return employeeDao.get(id);
	}

	public void delete(Employee e) {
		employeeDao.delete(e);
	}

	public Employee login(String employeeNum, String employeePwd) {
		return employeeDao.login(employeeNum, employeePwd);
	}

	public List<Employee> findAllbydept(Long sourcepostId) {
		return employeeDao.findAllbydept(sourcepostId);
	}

	public List<Employee> findAllEmployeeIn(Long departmentId) {
		return employeeDao.findAllEmployeeIn(departmentId);
	}
	
	public List<Employee> findAllEmployeeInPost(Long postId) {
		return employeeDao.findAllEmployeeInPost(postId);
	}

	public List<Employee> findPart(int size, int pageSize) {
		return employeeDao.findPart(size, pageSize);
	}

}

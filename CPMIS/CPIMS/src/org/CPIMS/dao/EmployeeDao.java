package org.CPIMS.dao;

import java.util.List;
import org.CPIMS.domain.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	SessionFactory sessionFactory;

	public void add(Employee e) {
		sessionFactory.getCurrentSession().save(e);
	}

	public void update(Employee e) {
		sessionFactory.getCurrentSession().update(e);
	}

	public void delete(Employee e) {
		e.setEmployeeState(false);
		sessionFactory.getCurrentSession().update(e);
	}

	public Employee get(Long id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {
		String hql = "from  Employee u where u.employeeState=true";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findPart(int size, int pageSize) {
		String hql = "from  Employee u where u.employeeState=true";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(size);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public Employee login(String employeeNum, String employeePwd) {
		String hql = "from Employee E where E.employeeNum=? and E.employeePwd=? and E.employeeState=true";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, employeeNum);
		query.setParameter(1, employeePwd);
		Employee E = (Employee) query.uniqueResult();
		return E;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllbydept(Long sourcepostId) {
		String hql = "from Employee d where d.employeeState=true and d.postId=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, sourcepostId);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployeeIn(Long departmentId) {
		String hql = "from Employee e where e.departmentId = ? and e.employeeState=true";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, departmentId);
		List<Employee> result = query.list();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployeeInPost(Long postId) {
		String hql = "from Employee e where e.postId = ? and e.employeeState=true";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, postId);
		List<Employee> result = query.list();
		return result;
	}
}

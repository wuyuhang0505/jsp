package org.CPIMS.dao;

import java.util.List;
import org.CPIMS.domain.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {
	@Autowired
	SessionFactory sessionFactory;

	public void add(Department d) {
		sessionFactory.getCurrentSession().save(d);
	}

	public void update(Department d) {
		sessionFactory.getCurrentSession().update(d);
	}

	public void delete(Department d) {
		d.setDepartmentState(false);
		sessionFactory.getCurrentSession().update(d);
	}
	
	public void reset(Department d){
		d.setDepartmentState(true);
		sessionFactory.getCurrentSession().update(d);
	}

	public Department get(Long departmentId) {
		return (Department) sessionFactory.getCurrentSession().get(Department.class, departmentId);
	}

	public Department get(String departmentNum) {
		String hql = "from Department d where d.departmentNum=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, departmentNum);
		Department d = (Department) query.uniqueResult();
		return d;
	}

	public void addDepartmentPostCount(Department d) {
		Integer tmp = d.getDepartmentPostCount();
		tmp++;
		d.setDepartmentPostCount(tmp);
		sessionFactory.getCurrentSession().update(d);
	}
	
	public void reduceDepartmentPostCount(Department d){
		Integer tmp = d.getDepartmentPostCount();
		tmp--;
		d.setDepartmentPostCount(tmp);
		sessionFactory.getCurrentSession().update(d);
	}
	
	public void addDepartmentEmployeeCount(Department d) {
		Integer tmp = d.getDepartmentEmployeeCount();
		tmp++;
		d.setDepartmentEmployeeCount(tmp);
		sessionFactory.getCurrentSession().update(d);
	}
	
	public void reduceDepartmentEmployeeCount(Department d){
		Integer tmp = d.getDepartmentEmployeeCount();
		tmp--;
		d.setDepartmentEmployeeCount(tmp);
		sessionFactory.getCurrentSession().update(d);
	}

	@SuppressWarnings("unchecked")
	public String findAllNum() {
		String hql = "select departmentNum from Department d where d.departmentState=true";
		Session session = sessionFactory.getCurrentSession();
		List<String> resultList = session.createQuery(hql).list();
		String result = "";
		for (int i = 0; i < resultList.size(); i++) {
			result += resultList.get(i) + " ";
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Department> findAll() {
		String hql = "from Department d where d.departmentState=true";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Department> findPart(int size,int pageSize) {
		String hql = "from Department d where d.departmentState=true";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql); 
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}

}

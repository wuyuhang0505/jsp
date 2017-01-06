package org.CPIMS.dao;

import java.util.List;

import org.CPIMS.domain.Task;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void add(Task t){
		sessionFactory.getCurrentSession().save(t);
	}
	
	public void update(Task t) {
		sessionFactory.getCurrentSession().update(t);
	}
	
	public void delete(Task t){
		sessionFactory.getCurrentSession().delete(t);
	}
	
	public Task get(Long taskId){
		return (Task)sessionFactory.getCurrentSession().get(Task.class, taskId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> findAll() {
		String hql = "from Task t";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> findPart(int size,int pageSize) {
		String hql = "from Task t";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql); 
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Task> findAll2(Long employeeId) {
		String hql = "from Task t where t.tasktakerId=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, employeeId);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> findCurrent(int size,int pageSize,Long employeeId){
		String hql = "from Task t where t.tasktakerId=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql); 
		query.setParameter(0, employeeId);
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}
}

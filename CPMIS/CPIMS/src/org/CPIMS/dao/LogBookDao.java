package org.CPIMS.dao;

import java.util.List;

import org.CPIMS.domain.LogBook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogBookDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void add(LogBook logbook){
		sessionFactory.getCurrentSession().save(logbook);
	}
	
	public void update(LogBook logbook) {
		sessionFactory.getCurrentSession().update(logbook);
	}
	
	public void delete(LogBook logbook){
		sessionFactory.getCurrentSession().delete(logbook);
	}
	
	public LogBook get(Long logBookId){
		return (LogBook)sessionFactory.getCurrentSession().get(LogBook.class, logBookId);
	}
	
	@SuppressWarnings("unchecked")
	public List<LogBook> findAll(Long id) {
		String hql = "from LogBook lb, Task t where t.taskId=lb.taskId and t.tasktakerId=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0,id);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public  List<LogBook> findPart(int size,int pageSize,Long id) {
		String hql = "select lb from  LogBook lb, Task t where t.taskId=lb.taskId and t.tasktakerId=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<LogBook> findLogBook(Long id) {
		String hql = "from LogBook lb where lb.taskId=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0,id);
		return query.list();
	}

}

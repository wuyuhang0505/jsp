package org.CPIMS.dao;

import java.util.List;
import org.CPIMS.domain.Specialistapply;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpecialistapplyDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void add(Specialistapply d){
		sessionFactory.getCurrentSession().save(d);
	}
	
	public void update(Specialistapply d) {
		sessionFactory.getCurrentSession().update(d);
	}
	
	public void delete(Specialistapply d){
		sessionFactory.getCurrentSession().delete(d);
	}
	
	public Specialistapply get(Long specialistapplyId){
		return (Specialistapply)sessionFactory.getCurrentSession().get(Specialistapply.class, specialistapplyId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Specialistapply> findAllAllowed() {
		String hql = "from Specialistapply d where d.applyPass = true";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Specialistapply> findAllToAllow() {
		String hql = "from Specialistapply d where d.applyPass = false";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Specialistapply> findPart(int size,int pageSize) {
		String hql = "from Specialistapply d where d.applyPass = false";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql); 
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Specialistapply> findPartAllowed(int size,int pageSize) {
		String hql = "from Specialistapply d where d.applyPass = true";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql); 
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}

}

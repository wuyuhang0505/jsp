package org.CPIMS.dao;

import java.util.List;

import org.CPIMS.domain.Information;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InformationDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void add(Information u){
		sessionFactory.getCurrentSession().save(u);
	}
	
	public void update(Information u) {
		sessionFactory.getCurrentSession().update(u);
	}
	
	public void delete(Information u){
		sessionFactory.getCurrentSession().delete(u);
	}
	
	public Information get(Long id){
		return (Information)sessionFactory.getCurrentSession().get(Information.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Information> findAll() {
		String hql = "from Information u";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
    
	@SuppressWarnings("unchecked")
	public List<Information> findPart(int size,int pageSize) {
		String hql = "from Information u";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql); 
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}
}

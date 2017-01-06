package org.CPIMS.dao;

import java.util.List;
import org.CPIMS.domain.Employ;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void add(Employ e){
		sessionFactory.getCurrentSession().save(e);
	}
	
	public void update(Employ e) {
		sessionFactory.getCurrentSession().update(e);
	}
	
	public void delete(Employ e){
		sessionFactory.getCurrentSession().delete(e);
	}
	
	public Employ get(Long id){
		return (Employ)sessionFactory.getCurrentSession().get(Employ.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employ> findAll() {
		String hql = "from Employ u";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employ> findPart(int size,int pageSize) {
		String hql = "from Employ e";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql); 
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}

}

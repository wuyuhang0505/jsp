package org.CPIMS.dao;

import java.util.List;
import org.CPIMS.domain.Move;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MoveDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void add(Move u){
		sessionFactory.getCurrentSession().save(u);
	}
	
	public void update(Move u) {
		sessionFactory.getCurrentSession().update(u);
	}
	
	public void delete(Move u){
		sessionFactory.getCurrentSession().delete(u);
	}
	
	public Move get(Long MoveId){
		return (Move)sessionFactory.getCurrentSession().get(Move.class, MoveId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Move> findAll() {
		String hql = "from Move u";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Move> findPart(int size,int pageSize) {
		String hql = "from Move p";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql); 
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}
}

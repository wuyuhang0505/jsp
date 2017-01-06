package org.CPIMS.dao;

import java.util.List;
import org.CPIMS.domain.RankApply;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RankApplyDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void add(RankApply d){
		sessionFactory.getCurrentSession().save(d);
	}
	
	public void update(RankApply d) {
		sessionFactory.getCurrentSession().update(d);
	}
	
	public void delete(RankApply d){
		sessionFactory.getCurrentSession().delete(d);
	}
	
	public RankApply get(Long RankApplyId){
		return (RankApply)sessionFactory.getCurrentSession().get(RankApply.class, RankApplyId);
	}
	
	@SuppressWarnings("unchecked")
	public List<RankApply> findAllTOAllow() {
		String hql = "from RankApply d where d.applyPass = false";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RankApply> findAllAllowed() {
		String hql = "from RankApply d where d.applyPass = true";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RankApply> findPart(int size,int pageSize) {
		String hql = "from RankApply d where d.applyPass = false";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql); 
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RankApply> findPartAllowed(int size,int pageSize) {
		String hql = "from RankApply d where d.applyPass = true";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql); 
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}

}

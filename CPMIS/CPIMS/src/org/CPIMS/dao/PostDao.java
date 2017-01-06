package org.CPIMS.dao;

import java.util.List;
import org.CPIMS.domain.Post;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void add(Post p){
		sessionFactory.getCurrentSession().save(p);
	}
	
	public void update(Post p) {
		sessionFactory.getCurrentSession().update(p);
	}
	
	public void delete(Post p){
		p.setpostState(false);
		sessionFactory.getCurrentSession().update(p);
	}
	
	public void reset(Post p){
		p.setpostState(true);
		sessionFactory.getCurrentSession().update(p);
	}
	
	public void addPostEmployeeCount(Post p){
		Integer tmp = p.getPostEmployeeCount();
		tmp++;
		p.setPostEmployeeCount(tmp);
		sessionFactory.getCurrentSession().update(p);
	}
	
	public void reducePostEmployeeCounr(Post p){
		Integer tmp = p.getPostEmployeeCount();
		tmp--;
		p.setPostEmployeeCount(tmp);
		sessionFactory.getCurrentSession().update(p);
	}
	
	public Post get(Long postId){
		return (Post)sessionFactory.getCurrentSession().get(Post.class, postId);
	}
	
	public Post get(String postNum){
		String hql = "from Post p where p.postNum=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0,postNum);
		Post p = (Post) query.uniqueResult();
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public String findAllNum() {
		String hql = "select postNum from Post p where p.postState=true";
		Session session = sessionFactory.getCurrentSession();
		List<String> resultList = session.createQuery(hql).list();
		String result = "";
		for (int i = 0; i < resultList.size(); i++) {
			result += resultList.get(i) + " ";
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Post> findAll() {
		String hql = "from Post p where p.postState=true";
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Post> findAllbydept(Long sourcedepartmentId) {
		String hql = "from Post d where d.departmentId=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, sourcedepartmentId);
		List<Post> result = query.list();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Post> findPart(int size,int pageSize) {
		String hql = "from Post p where p.postState=true";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql); 
		query.setFirstResult(size); 
		query.setMaxResults(pageSize); 
		return query.list();
	}

}

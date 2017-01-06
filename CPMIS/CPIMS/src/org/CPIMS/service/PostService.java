package org.CPIMS.service;

import java.util.List;
import javax.transaction.Transactional;
import org.CPIMS.dao.PostDao;
import org.CPIMS.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostService {
	@Autowired
	PostDao postDao;
	
	public void addPost(Post p){
		postDao.add(p);
	}

	public String findAllNum(){
		return postDao.findAllNum();
	}
	
	public List<Post> findAll() {
		return postDao.findAll();
	}

	public List<Post> findAllbydept(Long sourcedepartmentId) {
		return postDao.findAllbydept(sourcedepartmentId);
	}
	
	public void update(Post p) {
		postDao.update(p);
	}

	public Post get(Long id) {
		return postDao.get(id);
	}
	
	public Post get(String postNum){
		return postDao.get(postNum);
	}

	public void delete(Post p) {
		postDao.delete(p);
	}
	
	public void reset(Post p){
		postDao.reset(p);
	}
	
	public void addPostEmployeeCount(Post p){
		postDao.addPostEmployeeCount(p);
	}
	
	public void reducePostEmployeeCounr(Post p){
		postDao.reducePostEmployeeCounr(p);
	}
	
	public List<Post> findPart(int size,int pageSize) {
		return postDao.findPart(size,pageSize);
	}
}

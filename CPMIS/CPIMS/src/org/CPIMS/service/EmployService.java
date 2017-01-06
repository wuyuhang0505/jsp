package org.CPIMS.service;

import java.util.List;
import javax.transaction.Transactional;
import org.CPIMS.dao.EmployDao;
import org.CPIMS.domain.Employ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployService {
	@Autowired
	EmployDao employDao;
	
	public void addEmploy(Employ e){
		employDao.add(e);
	}

	public List<Employ> findAll() {
		return employDao.findAll();
	}

	public void update(Employ e) {
		employDao.update(e);
		
	}

	public Employ get(Long id) {
		return employDao.get(id);
	}

	public void delete(Employ e) {
		employDao.delete(e);
	}
	
	public List<Employ> findPart(int size,int pageSize) {
		return employDao.findPart(size,pageSize);
	}
}

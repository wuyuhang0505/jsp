package org.CPIMS.service;

import java.util.List;

import javax.transaction.Transactional;

import org.CPIMS.dao.InformationDao;
import org.CPIMS.domain.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InformationService {
	@Autowired
	InformationDao informationDao;
	
	public void addInformation(Information u){
		informationDao.add(u);
	}

	public List<Information> findAll() {
		return informationDao.findAll();
	}
	
	public List<Information> findPart(int size, int pageSize) {
		return informationDao.findPart(size,pageSize);
	}

	public void update(Information u) {
		informationDao.update(u);
		
	}

	public Information get(Long id) {
		return informationDao.get(id);
	}

	public void delete(Information u) {
		informationDao.delete(u);
	}

	
}

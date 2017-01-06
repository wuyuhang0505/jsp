package org.CPIMS.service;

import java.util.List;
import javax.transaction.Transactional;
import org.CPIMS.dao.SpecialistapplyDao;
import org.CPIMS.domain.Specialistapply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SpecialistapplyService {
	@Autowired
	SpecialistapplyDao specialistapplyDao;
	
	public void addSpecialistapply(Specialistapply d){
		specialistapplyDao.add(d);
	}

	public List<Specialistapply> findAllToAllow() {
		return specialistapplyDao.findAllToAllow();
	}

	public List<Specialistapply> findAllAllowed() {
		return specialistapplyDao.findAllAllowed();
	}
	
	public void update(Specialistapply d) {
		specialistapplyDao.update(d);
	}

	public Specialistapply get(Long id) {
		return specialistapplyDao.get(id);
	}

	public void delete(Specialistapply d) {
		specialistapplyDao.delete(d);
	}
	
	public List<Specialistapply> findPart(int size,int pageSize){
		return specialistapplyDao.findPart(size,pageSize);
	}
	
	public List<Specialistapply> findPartAllowed(int size,int pageSize){
		return specialistapplyDao.findPartAllowed(size,pageSize);
	}
}

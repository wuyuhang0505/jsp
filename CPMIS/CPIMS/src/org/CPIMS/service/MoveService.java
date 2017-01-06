package org.CPIMS.service;

import java.util.List;

import javax.transaction.Transactional;
import org.CPIMS.dao.MoveDao;
import org.CPIMS.domain.Move;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MoveService {
	@Autowired
	MoveDao moveDao;
	
	public void addMove(Move d){
		moveDao.add(d);
	}

	public List<Move> findAll() {
		return moveDao.findAll();
	}

	public void update(Move d) {
		moveDao.update(d);
	}

	public Move get(Long id) {
		return moveDao.get(id);
	}

	public void delete(Move d) {
		moveDao.delete(d);
	}
	
	public List<Move> findPart(int size,int pageSize) {
		return moveDao.findPart(size,pageSize);
	}
	
}

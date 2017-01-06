package org.CPIMS.service;

import java.util.List;

import javax.transaction.Transactional;

import org.CPIMS.dao.RankApplyDao;
import org.CPIMS.domain.RankApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RankApplyService {
	@Autowired
	RankApplyDao RankApplyDao;
	
	public void addRankApply(RankApply d){
		RankApplyDao.add(d);
	}

	public List<RankApply> findAllToAllow() {
		return RankApplyDao.findAllTOAllow();
	}
	
	public List<RankApply> findAllAllowed() {
		return RankApplyDao.findAllAllowed();
	}

	public void update(RankApply d) {
		RankApplyDao.update(d);
	}

	public RankApply get(Long id) {
		return RankApplyDao.get(id);
	}

	public void delete(RankApply d) {
		RankApplyDao.delete(d);
	}
	
	public List<RankApply> findPart(int size,int pageSize){
		return RankApplyDao.findPart(size,pageSize);
	}
	
	public List<RankApply> findPartAllowed(int size,int pageSize){
		return RankApplyDao.findPartAllowed(size,pageSize);
	}
	
}

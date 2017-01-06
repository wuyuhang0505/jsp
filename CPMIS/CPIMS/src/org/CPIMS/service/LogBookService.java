package org.CPIMS.service;

import java.util.List;

import javax.transaction.Transactional;

import org.CPIMS.dao.LogBookDao;

import org.CPIMS.domain.LogBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LogBookService {
	@Autowired
	LogBookDao LogBookDao;
	
	public void addDepartment(LogBook logbook){
		LogBookDao.add(logbook);
	}

	public void update(LogBook logbook) {
		LogBookDao.update(logbook);
	}

	public LogBook get(Long logBookId) {
		return LogBookDao.get(logBookId);
	}

	public void delete(LogBook logbook) {
		LogBookDao.delete(logbook);
	}

	public List<LogBook> findAll(Long id) {
		return LogBookDao.findAll(id);
	}
	
	public List<LogBook> findPart(int size,int pageSize,Long id) {
		return LogBookDao.findPart(size,pageSize,id);
	}
	
	public List<LogBook> findLogBook(Long id) {
		return LogBookDao.findLogBook(id);
	}
}

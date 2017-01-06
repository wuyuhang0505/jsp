package org.CPIMS.service;

import java.util.List;
import javax.transaction.Transactional;
import org.CPIMS.dao.TaskDao;
import org.CPIMS.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskService {
	@Autowired
	TaskDao taskDao;
	
	public void addtask(Task t){
		taskDao.add(t);
	}
	
	public void update(Task t) {
		taskDao.update(t);
	}
	
	public void delete(Task t) {
		taskDao.delete(t);
	}
	
	public Task get(Long taskid) {
		return taskDao.get(taskid);
	}
	
	public List<Task> findAll() {
		return taskDao.findAll();
	}
	
	public List<Task> findPart(int size,int pageSize) {
		return taskDao.findPart(size,pageSize);
	}
	
	public List<Task> findAll2(Long employeeId) {
		return taskDao.findAll2(employeeId);
	}
	
	public List<Task> findCurrent(int size,int pageSize,Long employeeId) {
		return taskDao.findCurrent(size,pageSize,employeeId);
	}
}

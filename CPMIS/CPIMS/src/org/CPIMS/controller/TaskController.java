package org.CPIMS.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.CPIMS.domain.Department;
import org.CPIMS.domain.Employee;
import org.CPIMS.domain.LogBook;
import org.CPIMS.domain.TaskVo;
import org.CPIMS.domain.Task;
import org.CPIMS.domain.Post;
import org.CPIMS.service.DepartmentService;
import org.CPIMS.service.EmployeeService;
import org.CPIMS.service.LogBookService;
import org.CPIMS.service.TaskService;
import org.CPIMS.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskService taskService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	PostService postService;
	@Autowired
	LogBookService logBookService;

	
	@RequestMapping("/toSave")
	public String toSave(Long taskId, String optype, String sourcedepartmentId, String destdepartmentId,
			String sourcepostId, String destpostId,String sourceemployeeId,Model model) {
		if (taskId != null) {
			Task task = taskService.get(taskId);
			model.addAttribute("task", task);
		}
		List<Department> departmentList = departmentService.findAll();
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("secondselcID", destdepartmentId);
		model.addAttribute("firstselcID", sourcedepartmentId);
		model.addAttribute("firspostID", sourcepostId);
		model.addAttribute("secondpostID", destpostId);
		model.addAttribute("sourceempID", sourceemployeeId);
		int opttype = 1;
		if (optype != null)
			opttype = Integer.parseInt(optype);

		if (opttype == 1) {
			if (sourcedepartmentId != "" && sourcedepartmentId != null) {
				Long l = Long.valueOf(sourcedepartmentId);
				List<Post> firstpostList = postService.findAllbydept(l);
				model.addAttribute("firstpostList", firstpostList);
			}
		}
		if (opttype == 2) {
			if (sourcedepartmentId != "" && sourcedepartmentId != null) {
				Long l = Long.valueOf(sourcedepartmentId);
				List<Post> firstpostList = postService.findAllbydept(l);
				model.addAttribute("firstpostList", firstpostList);
			}
			if (sourcepostId != "" && sourcepostId != null) {
				Long l = Long.valueOf(sourcepostId);
				List<Employee> firstempList = employeeService.findAllbydept(l);
				model.addAttribute("firstempList", firstempList);
			}

			if (destdepartmentId != "" && destdepartmentId != null) {
				Long l = Long.valueOf(destdepartmentId);
				List<Post> secondpostList = postService.findAllbydept(l);
				model.addAttribute("secondpostList", secondpostList);
			}
		}
		if (opttype == 11) {

			if (sourcedepartmentId != "" && sourcedepartmentId != null) {
				Long l = Long.valueOf(sourcedepartmentId);
				List<Post> firstpostList = postService.findAllbydept(l);
				model.addAttribute("firstpostList", firstpostList);
			}

			if (sourcepostId != "" && sourcepostId != null) {
				Long l = Long.valueOf(sourcepostId);
				List<Employee> firstempList = employeeService.findAllbydept(l);
				model.addAttribute("firstempList", firstempList);
			}
		}
			if (opttype == 21) {

				if (sourcedepartmentId != "" && sourcedepartmentId != null) {
					Long l = Long.valueOf(sourcedepartmentId);
					List<Post> firstpostList = postService.findAllbydept(l);
					model.addAttribute("firstpostList", firstpostList);
				}
				if (sourcepostId != "" && sourcepostId != null) {
					Long l = Long.valueOf(sourcepostId);
					List<Employee> firstempList = employeeService.findAllbydept(l);
					model.addAttribute("firstempList", firstempList);
				}
				if (destdepartmentId != "" && destdepartmentId != null) {
					Long l = Long.valueOf(destdepartmentId);
					List<Post> secondpostList = postService.findAllbydept(l);
					model.addAttribute("secondpostList", secondpostList);
				}

				if (destpostId != "" && destpostId != null) {
					Long l = Long.valueOf(destpostId);
					List<Employee> secondempList = employeeService.findAllbydept(l);
					model.addAttribute("secondempList", secondempList);
				}
		}
		return "/task/save";
	}
	
	@RequestMapping("/save")
	public String addtask(Task t){
		taskService.addtask(t);
		return "redirect:/task/list";
	}
	
	@RequestMapping("/edit")
	public String edit(Task t) {
		taskService.update(t);
		return "redirect:/task/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Long taskId,HttpSession session) {
		Task t = taskService.get(taskId);
		Employee e =(Employee)session.getAttribute("currentEmployee");
		if (t != null&&(e.getEmployeeId()==1||e.getEmployeeId()==t.getEmployeeId())){
			List<LogBook> lbList = logBookService.findLogBook(taskId);
			for(LogBook lb : lbList){
				logBookService.delete(lb);
			}
			taskService.delete(t);
		}
		return "redirect:/task/list";
	}
	
	@RequestMapping("/list")
	public String list(String showPage,Model model) {
		int pageSize=10;
		int recordCount; 
		int pageCount;   
		List<Task> taskL = taskService.findAll();
		recordCount=taskL.size();
		model.addAttribute("recordCount",recordCount);
		if (recordCount>=10&&recordCount%pageSize==0){
			pageCount = recordCount/pageSize;
		}
		else
			pageCount = recordCount/pageSize+1;
		model.addAttribute("pageCount",pageCount);
		if(showPage==null){
			showPage="1";
		}else{
			if(Integer.parseInt(showPage)<=1){
				showPage="1";
			}
			if(Integer.parseInt(showPage)>=pageCount){
				showPage=Integer.toString(pageCount);
			}
		}
		int size=(Integer.parseInt(showPage)-1)*pageSize;
		model.addAttribute("showPage",Integer.parseInt(showPage));
		List<Task> taskList=taskService.findPart(size,pageSize);
		List<Department> departmentNameList =departmentService.findAll();
		List<Post> postNameList=postService.findAll();
		List<Employee> employeeNameList=employeeService.findAll();
		List<TaskVo> tasklistvo=new ArrayList<TaskVo>();
		for(Task task : taskList){
			TaskVo taskvo=new TaskVo();
			for (Department d : departmentNameList) {
				if(task.getSourcedepartmentId()==d.getDepartmentId())
				{
					taskvo.setSourcedepartmentName(d.getDepartmentName());
				}
				if(task.getDestdepartmentId()==d.getDepartmentId())
				{
					taskvo.setDestdepartmentName(d.getDepartmentName());
				}
			}
			for(Post p:postNameList){
				if(task.getSourcepostId()==p.getPostId()){
					taskvo.setSourcepostName(p.getPostName());
				}
				if(task.getDestpostId()==p.getPostId()){
					taskvo.setDestpostName(p.getPostName());
				}
			}
			for(Employee e:employeeNameList){
				if(task.getEmployeeId()==e.getEmployeeId()){
					taskvo.setSourceemployeeName(e.getEmployeeName());
					taskvo.setSourceemployeeNum(e.getEmployeeNum());
				}
				if(task.getTasktakerId()==e.getEmployeeId()){
					taskvo.setDestemployeeName(e.getEmployeeName());
					taskvo.setDestemployeeNum(e.getEmployeeNum());
				}
			}
			taskvo.setTaskId(task.getTaskId());
			taskvo.setTaskName(task.getTaskName());
			taskvo.setContext(task.getContext());	
			taskvo.setTaskNum(task.getTaskNum());
			taskvo.setTaskStarTime(task.getTaskStarTime());
			tasklistvo.add(taskvo);
		}
		model.addAttribute("taskList",tasklistvo);
		return "task/list";
	}
	
	@RequestMapping("/currentlist")
	public String currentlist(String showPage,Model model,Long id){
		int pageSize=10;
		int recordCount; //鎬昏褰曟暟
		int pageCount;   //鎬婚〉鏁�
		List<Task> tasks = taskService.findAll2(id);
		recordCount=tasks.size();
		model.addAttribute("recordCount",recordCount);
		if (recordCount>=10&&recordCount%pageSize==0){
			pageCount = recordCount/pageSize;
		}
		else
			pageCount = recordCount/pageSize+1;
		model.addAttribute("pageCount",pageCount);
		if(showPage==null){
			showPage="1";
		}else{
			if(Integer.parseInt(showPage)<=1){
				showPage="1";
			}
			if(Integer.parseInt(showPage)>=pageCount){
				showPage=Integer.toString(pageCount);
			}
		}
		int size=(Integer.parseInt(showPage)-1)*pageSize;
		model.addAttribute("sPage",Integer.parseInt(showPage));
		List<Task> taskList=taskService.findCurrent(size,pageSize,id);
		List<Department> departmentNameList =departmentService.findAll();
		List<Post> postNameList=postService.findAll();
		List<Employee> employeeNameList=employeeService.findAll();
		List<TaskVo> tasklistvo=new ArrayList<TaskVo>();
		for(Task task : taskList){
			TaskVo taskvo=new TaskVo();
			for (Department d : departmentNameList) {
				if(task.getSourcedepartmentId()==d.getDepartmentId())
				{
					taskvo.setSourcedepartmentName(d.getDepartmentName());
				}
				if(task.getDestdepartmentId()==d.getDepartmentId())
				{
					taskvo.setDestdepartmentName(d.getDepartmentName());
				}
			}
			for(Post p:postNameList){
				if(task.getSourcepostId()==p.getPostId()){
					taskvo.setSourcepostName(p.getPostName());
				}
				if(task.getDestpostId()==p.getPostId()){
					taskvo.setDestpostName(p.getPostName());
				}
			}
			for(Employee e:employeeNameList){
				if(task.getEmployeeId()==e.getEmployeeId()){
					taskvo.setSourceemployeeName(e.getEmployeeName());
					taskvo.setSourceemployeeNum(e.getEmployeeNum());
				}
				if(task.getTasktakerId()==e.getEmployeeId()){
					taskvo.setDestemployeeName(e.getEmployeeName());
					taskvo.setDestemployeeNum(e.getEmployeeNum());
				}
			}
			taskvo.setTaskId(task.getTaskId());
			taskvo.setTaskName(task.getTaskName());
			taskvo.setContext(task.getContext());	
			taskvo.setTaskNum(task.getTaskNum());
			taskvo.setTaskStarTime(task.getTaskStarTime());
			tasklistvo.add(taskvo);
		}
		model.addAttribute("taskList",tasklistvo);
		return "task/currentlist";
	}
	
}

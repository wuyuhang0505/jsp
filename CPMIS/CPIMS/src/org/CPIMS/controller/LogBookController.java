package org.CPIMS.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.CPIMS.domain.Employee;
import org.CPIMS.domain.LogBook;
import org.CPIMS.domain.Task;
import org.CPIMS.service.LogBookService;
import org.CPIMS.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logBook")
public class LogBookController {

	@Autowired
	LogBookService LogBookService;
	@Autowired
	TaskService taskService;

	@RequestMapping("/save")
	public String addLogBook(LogBook logbook, HttpSession session) {
		LogBookService.addDepartment(logbook);
		Employee employee = (Employee) session.getAttribute("currentEmployee");
		if (employee != null) {
			//model.addAttribute("id", employee.getEmployeeId());
			return "redirect:/task/currentlist?id="+employee.getEmployeeId();
		} else
			return "../index";
	}
    
	@RequestMapping("/toEdit")
	public String toEdit(Long logBookId, Model model) {
		if(logBookId!=null){
			  LogBook logbook=LogBookService.get(logBookId);
			  model.addAttribute("logbook", logbook);
		}
		return "/task/logedit";
	}
	
	@RequestMapping("/edit")
	public String edit(LogBook logbook, HttpSession session) {
		Employee employee = (Employee) session.getAttribute("currentEmployee");
		  LogBookService.update(logbook);
		 return "redirect:/logBook/list?id="+employee.getEmployeeId();
	}

	@RequestMapping("/delete")
	public String delete(Long logBookId,Long id) {
		LogBook d = LogBookService.get(logBookId);
		if (d != null){
			LogBookService.delete(d);
		}
		return "redirect:/logBook/list?id="+id;

	}

	@RequestMapping("/toSave")
	public String toSave(Long taskId, Model model) {
		if (taskId != null) {
			Task task = taskService.get(taskId);
			model.addAttribute("task", task);
		}
		return "/task/logsave";
	}

	@RequestMapping("/list")
	public String list(String showPage, Model model, Long id) {
		int pageSize = 10;
		int recordCount; // 总记录数
		int pageCount; // 总页数
		List<LogBook> logList = LogBookService.findAll(id);
		recordCount = logList.size();
		model.addAttribute("recordCount", recordCount);
		if (recordCount >= 10 && recordCount % pageSize == 0) {
			pageCount = recordCount / pageSize;
		} else {
			pageCount = recordCount / pageSize + 1;
		}
		model.addAttribute("pageCount", pageCount);
		if (showPage == null) {
			showPage = "1";
		} else {
			if (Integer.parseInt(showPage) <= 1) {
				showPage = "1";
			}
			if (Integer.parseInt(showPage) >= pageCount) {
				showPage = Integer.toString(pageCount);
			}
		}
		int size = (Integer.parseInt(showPage) - 1) * pageSize;
		model.addAttribute("showPage", Integer.parseInt(showPage));
		List<LogBook> logs = LogBookService.findPart(size, pageSize, id);
		model.addAttribute("logList", logs);
		return "task/loglist";
	}

}

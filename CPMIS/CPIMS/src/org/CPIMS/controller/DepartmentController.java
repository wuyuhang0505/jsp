package org.CPIMS.controller;

import java.util.List;
import org.CPIMS.domain.Department;
import org.CPIMS.domain.Employee;
import org.CPIMS.domain.Post;
import org.CPIMS.service.DepartmentService;
import org.CPIMS.service.EmployeeService;
import org.CPIMS.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	PostService postService;

	@RequestMapping("/save")
	public String addDepartment(Department d) {
		Department t = departmentService.get(d.getDepartmentNum());
		if (t == null) {
			departmentService.addDepartment(d);
		} else {
			t.setDepartmentName(d.getDepartmentName());
			departmentService.reset(t);
		}
		return "redirect:/department/list";
	}

	@RequestMapping("/edit")
	public String edit(Department u) {
		Department d = departmentService.get(u.getDepartmentId());
		d.setDepartmentChief(u.getDepartmentChief());
		d.setDepartmentChiefNa(u.getDepartmentChiefNa());
		d.setRemark(u.getRemark());
		departmentService.update(d);
		return "redirect:/department/list";
	}

	@RequestMapping("/delete")
	public String delete(Long id) {
		Department d = departmentService.get(id);
		List<Post> pList = postService.findAllbydept(id);
		for (Post p : pList) {
			postService.delete(p);
		}
		if (d != null)
			departmentService.delete(d);
		return "redirect:/department/list";
	}

	@RequestMapping("/toSave")
	public String toSave(Long id, Model model) {
		if (id != null) {
			Department department = departmentService.get(id);
			model.addAttribute("department", department);
		}
		model.addAttribute("deNumList", departmentService.findAllNum());
		return "/department/save";
	}

	@RequestMapping("/list")
	public String list(String showPage, Model model) {
		int pageSize = 10;
		int recordCount; // 总记录数
		int pageCount; // 总页数
		List<Department> departmentList = departmentService.findAll();
		recordCount = departmentList.size();
		model.addAttribute("recordCount", recordCount);
		if (recordCount >= 10 && recordCount % pageSize == 0) {
			pageCount = recordCount / pageSize;
		} else
			pageCount = recordCount / pageSize + 1;
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
		List<Department> departments = departmentService.findPart(size, pageSize);
		model.addAttribute("departmentList", departments);
		return "department/list";
	}

	@RequestMapping("/setManager")
	public String setManager(Long id, Model model) {
		Department department = departmentService.get(id);
		model.addAttribute("department", department);
		List<Employee> empList = employeeService.findAllEmployeeIn(id);
		model.addAttribute("empList", empList);
		return "/department/set";
	}

}

package org.CPIMS.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.CPIMS.domain.Department;
import org.CPIMS.domain.EmployeVo;
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
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	PostService postService;
	@RequestMapping("/save")
	public String addemploy(Employee u) {
		employeeService.addEmployee(u);
		Department d = departmentService.get(u.getDepartmentId());
		departmentService.addDepartmentEmployeeCount(d);
		Post p = postService.get(u.getPostId());
		postService.addPostEmployeeCount(p);
		return "redirect:/employee/list";
	}

	@RequestMapping("/edit")
	public String edit(Employee u) {
		employeeService.update(u);
		return "redirect:/employee/list";
	}

	@RequestMapping("/delete")
	public String delete(Long id) {
		Employee u = employeeService.get(id);
		if (u != null)
			employeeService.delete(u);
		Department d = departmentService.get(u.getDepartmentId());
		departmentService.reduceDepartmentEmployeeCount(d);
		Post p = postService.get(u.getPostId());
		postService.reducePostEmployeeCounr(p);
		return "redirect:/employee/list";
	}

	@RequestMapping("/toSave")
	public String toSave(Long id,String departmentId, Model model) {
		if (id != null) {
			Employee employee = employeeService.get(id);
			model.addAttribute("employee", employee);
		}
		List<Department> departmentList = departmentService.findAll();
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("selcID",departmentId);
		if(departmentId!=""&&departmentId!=null)
		{
			Long l =Long.parseLong(departmentId);
		  List<Post> postList = postService.findAllbydept(l);
		  model.addAttribute("postList", postList);
		}
		return "/employee/save";
	}
	
	@RequestMapping("/toEdit")
	public String toEdit(Long id,String departmentId, Model model) {
		List<Department> departmentList = departmentService.findAll();
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("selcID",departmentId);
		Employee employee = employeeService.get(id);
		model.addAttribute("employee", employee);
		
		if(departmentId!=""&&departmentId!=null)
		{
			Long l = Long.parseLong(departmentId);
		  List<Post> postList = postService.findAllbydept(l);
		  model.addAttribute("postList", postList);
		}
		return "/employee/edit";
	}

	@RequestMapping("/list")
	public String list(String showPage,Model model) {
		int pageSize=10;
		int recordCount; //鎬昏褰曟暟
		int pageCount;   //鎬婚〉鏁�
		List<Employee> employList = employeeService.findAll();
		recordCount=employList.size();
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
		List<Employee> employeeList=employeeService.findPart(size,pageSize);
		//全锟斤拷锟斤拷锟斤拷
		List<Department> departmentNameList =departmentService.findAll();
		List<Post> postNameList=postService.findAll();
		List<EmployeVo> employeelistvo=new 	ArrayList<EmployeVo>();
		for(Employee employee : employeeList){
			EmployeVo emvo=new EmployeVo();
			for (Department d : departmentNameList) {
				if(employee.getDepartmentId()==d.getDepartmentId())
				{
					emvo.setDepartmentName(d.getDepartmentName());
				}
			}
			for(Post p:postNameList){
				if(employee.getPostId()==p.getPostId()){
					emvo.setPostName(p.getPostName());
				}
			}
			emvo.setEmployeeId(employee.getEmployeeId());
			emvo.setEmployeeName(employee.getEmployeeName());
			emvo.setEmployeePwd(employee.getEmployeePwd());	
			emvo.setEmployeeAddress(employee.getEmployeeAddress());
			emvo.setEmployeeAge(employee.getEmployeeAge());
			emvo.setEmployeeContractLength(employee.getEmployeeContractLength());
			emvo.setEmployeeContractTime(employee.getEmployeeContractTime());
			emvo.setEmployeeEdu(employee.getEmployeeEdu());
			emvo.setEmployeeIdcard(employee.getEmployeeIdcard());
			emvo.setEmployeeNation(employee.getEmployeeNation());
			emvo.setEmployeeNum(employee.getEmployeeNum());
			emvo.setEmployeeSex(employee.getEmployeeSex());
			emvo.setEmployeeState(employee.getEmployeeState());
			emvo.setIsSpecialist(employee.getIsSpecialist());
			emvo.setEmployeeTechPost(employee.getEmployeeTechPost());
			
			employeelistvo.add(emvo);
		}
		model.addAttribute("employeeList", employeelistvo);
		return "employee/list";

	}

	@RequestMapping("/toLogin")
	public String tologin() {
		return "index";
	}
	
	@RequestMapping("/logout")
	public String tologinout(HttpSession session) {
		session.invalidate();
		return "redirect:toLogin";
	}
	
	@RequestMapping("/login")
	public String login(String employeeNum, String employeePwd,String loginkeeping, HttpServletRequest request,HttpServletResponse response ) {
		Employee employee = employeeService.login(employeeNum, employeePwd);
		if (employee == null) {
			return "/loginError";
		} else {
			if(loginkeeping!=null&&loginkeeping.equals(loginkeeping)){
			Cookie cookie1= new Cookie("employeeNum",employeeNum);
			response.addCookie(cookie1);
			cookie1.setMaxAge(7*24*3600);
			Cookie cookie2= new Cookie("employeePwd",employeePwd);
			response.addCookie(cookie2);
			cookie2.setMaxAge(7*24*3600);
			}
			request.getSession().setAttribute("currentEmployee", employee);
			if (employee.getDepartmentId() == 1) {
				return "/admin";
			}else if (employee.getPostId() == 2) {
				return "/personnelManager";
			}else if (employee.getPostId() == 3) {
				return "/institutionManager";
			}else if (employee.getPostId() == 4) {
				return "/taskManager";
			}else{
				return "/others";
			}
		}
	}

}
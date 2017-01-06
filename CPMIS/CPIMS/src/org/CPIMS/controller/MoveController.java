package org.CPIMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.CPIMS.domain.Department;
import org.CPIMS.domain.Employee;
import org.CPIMS.domain.Move;
import org.CPIMS.domain.MoveVo;
import org.CPIMS.domain.Post;
import org.CPIMS.service.DepartmentService;
import org.CPIMS.service.EmployeeService;
import org.CPIMS.service.MoveService;
import org.CPIMS.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/move")
public class MoveController {

	@Autowired
	MoveService moveService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	PostService postService;

	@RequestMapping("/save")
	public String addMove(Move d) {
		moveService.addMove(d);
		Employee e = employeeService.get(d.getEmployeeId());
		Department de = departmentService.get(d.getSourcedepartmentId());
		if(d.getSourcedepartmentId()!=d.getDestdepartmentId()){
			departmentService.reduceDepartmentEmployeeCount(de);
			departmentService.addDepartmentEmployeeCount(departmentService.get(d.getDestdepartmentId()));
			if(e.getEmployeeId()==de.getDepartmentChief()){
				de.setDepartmentChief(null);
				de.setDepartmentChiefNa(null);
			}
		}
		if(d.getSourcepostId()!=d.getDestpostId()){
			postService.reducePostEmployeeCounr(postService.get(d.getSourcepostId()));
			postService.addPostEmployeeCount(postService.get(d.getDestpostId()));
		}
		e.setDepartmentId(d.getDestdepartmentId());
		e.setPostId(d.getDestpostId());
		employeeService.update(e);
		//employeeService.moveUpdate(d.getEmployeeId(), d.getDestdepartmentId(), d.getDestpostId());
		return "redirect:/move/list";
	}

	@RequestMapping("/edit")
	public String edit(Move u) {
		moveService.update(u);
		return "redirect:/move/list";
	}

	@RequestMapping("/delete")
	public String delete(Long id) {
		Move d = moveService.get(id);
		if (d != null)
			moveService.delete(d);
		return "redirect:/move/list";
	}

	@RequestMapping("/toSave")
	public String toSave(Long id, String optype, String sourcedepartmentId, String destdepartmentId,
			String sourcepostId, Model model) {
		if (id != null) {
			Move move = moveService.get(id);
			model.addAttribute("move", move);
		}

		List<Department> departmentList = departmentService.findAll();
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("firstselcID", sourcedepartmentId);
		model.addAttribute("firspostID", sourcepostId);
		model.addAttribute("secondselcID", destdepartmentId);
		int opttype=1;
		if(optype!=null)
			opttype=Integer.parseInt(optype);
		
		
		if (opttype==1) {
			if (sourcedepartmentId != "" && sourcedepartmentId != null) {
				Long l =Long.parseLong(sourcedepartmentId);
				List<Post> firstpostList = postService.findAllbydept(l);
				model.addAttribute("firstpostList", firstpostList);
			}
		}
		if (opttype==2) {
			if (sourcedepartmentId != "" && sourcedepartmentId != null) {
				Long l =Long.parseLong(sourcedepartmentId);
				List<Post> firstpostList = postService.findAllbydept(l);
				model.addAttribute("firstpostList", firstpostList);
			}
			if (sourcepostId != "" && sourcepostId != null) {
				Long l =Long.parseLong(sourcepostId);
				List<Employee> empList = employeeService.findAllbydept(l);
				model.addAttribute("empList", empList);
			}
			
			
			if (destdepartmentId != "" && destdepartmentId != null) {
				Long l =Long.parseLong(destdepartmentId);
				List<Post> secondpostList = postService.findAllbydept(l);
				model.addAttribute("secondpostList", secondpostList);
			}
		}
		if (opttype==11) {
			
			if (sourcedepartmentId != "" && sourcedepartmentId != null) {
				Long l =Long.parseLong(sourcedepartmentId);
				List<Post> firstpostList = postService.findAllbydept(l);
				model.addAttribute("firstpostList", firstpostList);
			}
			
			
			if (sourcepostId != "" && sourcepostId != null) {
				Long l =Long.parseLong(sourcepostId);
				List<Employee> empList = employeeService.findAllbydept(l);
				model.addAttribute("empList", empList);
			}
		}
		return "/move/save";
	}

	@RequestMapping("/list")
	public String list(Model model, String showPage) {
		int pageSize = 10;
		int recordCount; // 鎬昏褰曟暟
		int pageCount; // 鎬婚〉鏁�
		List<Move> moves = moveService.findAll();
		recordCount = moves.size();
		model.addAttribute("recordCount", recordCount);
		if (recordCount >= 15 && recordCount % pageSize == 0) {
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
		List<Move> moveList = moveService.findPart(size, pageSize);
		
		List<Employee> employeeNameList=employeeService.findAll();
		List<Department> departmentNameList=departmentService.findAll();
		List<Post> postNameList=postService.findAll();
		List<MoveVo> moveVoList=new ArrayList<MoveVo>();
		for(Move move : moveList){
			MoveVo moVo=new MoveVo();
			for(Employee e:employeeNameList){
				if(move.getEmployeeId()==e.getEmployeeId()){
					moVo.setEmployeeNum(e.getEmployeeNum());
					moVo.setEmployeeName(e.getEmployeeName());
				}
			}
			for(Department d:departmentNameList){
				if(move.getSourcedepartmentId()==d.getDepartmentId())
				{
					moVo.setSourcedepartmentName(d.getDepartmentName());
				}
				if(move.getDestdepartmentId()==d.getDepartmentId()){
					moVo.setDestdepartmentName(d.getDepartmentName());
				}
			}
			for(Post p:postNameList){
				if(move.getSourcepostId()==p.getPostId()){
					moVo.setSourcepostName(p.getPostName());
				}
				if(move.getDestpostId()==p.getPostId()){
					moVo.setDestpostName(p.getPostName());
				}
			}
			moVo.setMoveId(move.getMoveId());
			moVo.setMoveTime(move.getMoveTime());
			moVo.setMoveReason(move.getMoveReason());
			moveVoList.add(moVo);
		}
		model.addAttribute("moveList", moveVoList);
		return "move/list";
	}

}

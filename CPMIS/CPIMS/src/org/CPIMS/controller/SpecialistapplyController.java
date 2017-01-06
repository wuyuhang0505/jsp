package org.CPIMS.controller;

import java.util.List;
import org.CPIMS.domain.Employee;
import org.CPIMS.domain.Specialistapply;
import org.CPIMS.service.EmployeeService;
import org.CPIMS.service.SpecialistapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/specialistapply")
public class SpecialistapplyController {

	@Autowired
	SpecialistapplyService specialistapplyService;

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/save")
	public String addspecialistapply(Specialistapply d) {
		d.setApplyPass(false);
		specialistapplyService.addSpecialistapply(d);
		return "redirect:/specialistapply/list";
	}

	@RequestMapping("/edit")
	public String edit(Specialistapply u) {
		specialistapplyService.update(u);
		return "redirect:/specialistapply/list";
	}

	@RequestMapping("/delete")
	public String delete(Long id) {
		Specialistapply d = specialistapplyService.get(id);
		if (d != null)
			specialistapplyService.delete(d);
		return "redirect:/specialistapply/list";
	}

	@RequestMapping("/toSave")
	public String toSave(Long id, Model model) {
		if (id != null) {
			Specialistapply specialistapply = specialistapplyService.get(id);
			model.addAttribute("specialistapply", specialistapply);
		}
		return "/specialistapply/save";
	}

	@RequestMapping("/list")
	public String list(Model model, String showPage) {
		int pageSize = 10;
		int recordCount; // 总记录数
		int pageCount; // 总页数
		List<Specialistapply> applyList = specialistapplyService.findAllToAllow();
		recordCount = applyList.size();
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
		List<Specialistapply> specialistapplyList = specialistapplyService.findPart(size, pageSize);
		model.addAttribute("specialistapplyList", specialistapplyList);
		return "specialistapply/list";
	}

	@RequestMapping("/allowedlist")
	public String allowedList(Model model, String showPage) {
		int pageSize = 10;
		int recordCount; // 总记录数
		int pageCount; // 总页数
		List<Specialistapply> applyList = specialistapplyService.findAllAllowed();
		recordCount = applyList.size();
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
		List<Specialistapply> specialistapplyList = specialistapplyService.findPartAllowed(size, pageSize);
		model.addAttribute("specialistapplyList", specialistapplyList);
		return "specialistapply/allowedlist";
	}

	@RequestMapping("/allowspecialist")
	public String allowSpecialist(Long id, Long sId) {
		Employee u = employeeService.get(id);
		if (u != null) {
			u.setIsSpecialist(true);
			employeeService.update(u);
		}
		Specialistapply d = specialistapplyService.get(sId);
		if (d != null) {
			d.setApplyPass(true);
			specialistapplyService.update(d);
		}
		return "redirect:/employee/list";

	}

}

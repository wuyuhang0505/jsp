package org.CPIMS.controller;

import java.util.List;
import org.CPIMS.domain.Employee;
import org.CPIMS.domain.RankApply;
import org.CPIMS.service.EmployeeService;
import org.CPIMS.service.RankApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rankapply")
public class RankApplyController {

	@Autowired
	RankApplyService RankApplyService;

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/save")
	public String addRankApply(RankApply d) {
		d.setApplyPass(false);
		RankApplyService.addRankApply(d);
		return "redirect:/rankapply/list";
	}

	@RequestMapping("/edit")
	public String edit(RankApply u) {
		RankApplyService.update(u);
		return "redirect:/rankapply/list";
	}

	@RequestMapping("/delete")
	public String delete(Long id) {
		RankApply d = RankApplyService.get(id);
		if (d != null)
			RankApplyService.delete(d);
		return "redirect:/rankapply/list";
	}

	@RequestMapping("/toSave")
	public String toSave(Long id, Model model) {
		if (id != null) {
			RankApply RankApply = RankApplyService.get(id);
			model.addAttribute("RankApply", RankApply);
		}
		return "/rankapply/save";
	}

	@RequestMapping("/list")
	public String list(String showPage, Model model) {
		int pageSize = 10;
		int recordCount; // 总记录数
		int pageCount; // 总页数
		List<RankApply> applyList = RankApplyService.findAllToAllow();
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
		List<RankApply> RankApplyList = RankApplyService.findPart(size, pageSize);
		model.addAttribute("RankApplyList", RankApplyList);
		return "/rankapply/list";
	}

	@RequestMapping("/allowedlist")
	public String allowedList(String showPage, Model model) {
		int pageSize = 10;
		int recordCount; // 总记录数
		int pageCount; // 总页数
		List<RankApply> applyList = RankApplyService.findAllAllowed();
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
		List<RankApply> RankApplyList = RankApplyService.findPartAllowed(size, pageSize);
		model.addAttribute("RankApplyList", RankApplyList);
		return "/rankapply/allowedlist";
	}

	@RequestMapping("/allowrank")
	public String allowRank(Long id, Long rId) {
		Employee u = employeeService.get(id);
		if (u != null) {
			int rank = u.getEmployeeTechPost();
			u.setEmployeeTechPost(++rank);
			employeeService.update(u);
		}
		RankApply d = RankApplyService.get(rId);
		if (d != null) {
			d.setApplyPass(true);
			RankApplyService.update(d);
		}
		return "redirect:/employee/list";

	}

}

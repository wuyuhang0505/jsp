package org.CPIMS.controller;

import java.util.List;
import org.CPIMS.domain.Employ;
import org.CPIMS.domain.Post;
import org.CPIMS.service.EmployService;
import org.CPIMS.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employ")
public class EmployController {

	@Autowired
	EmployService employService;
	
	@Autowired
	PostService postService;


	@RequestMapping("/save")
	public String addemploy(Employ u) {
		employService.addEmploy(u);
		return "redirect:/employ/list";
	}

	@RequestMapping("/edit")
	public String edit(Employ u) {
		employService.update(u);
		return "redirect:/employ/list";
	}

	@RequestMapping("/delete")
	public String delete(Long id) {
		Employ u = employService.get(id);
		if (u != null)
			employService.delete(u);
		return "redirect:/employ/list";
	}

	@RequestMapping("/toSave")
	public String toSave(Long id,String postId, Model model) {
		if (id != null) {
			Employ employ = employService.get(id);
			model.addAttribute("employ", employ);
		}
		List<Post> postList = postService.findAll();
		model.addAttribute("postList", postList);
		return "/employ/save";
	}

	@RequestMapping("/list")
	public String list(String showPage,Model model) {
		int pageSize=10;
		int recordCount; //总记录数
		int pageCount;   //总页数
		List<Employ> employList = employService.findAll();
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
		List<Employ> employs=employService.findPart(size,pageSize);
		model.addAttribute("employList",employs);
		return "employ/list";
	}
	

}
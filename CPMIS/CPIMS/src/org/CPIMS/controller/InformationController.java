package org.CPIMS.controller;

import java.util.List;
import org.CPIMS.domain.Information;
import org.CPIMS.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/InforMation")
public class InformationController {

	@Autowired
	InformationService informationService;

	@RequestMapping("/save")
	public String addinformation(Information u) {
		informationService.addInformation(u);
		return "redirect:/InforMation/list";
	}

	
	@RequestMapping("/check")
	public String edit(Long informId,Model model) {
		Information u = informationService.get(informId);
		if (u != null){
		    model.addAttribute("informtion",u);
		    return "/information/check";
		}
		else
		    return "redirect:/InforMation/list";
	}

	@RequestMapping("/delete")
	public String delete(Long informId,Long id) {
		Information u = informationService.get(informId);
		if (u != null&&(u.getEmployeeId()==id||u.getEmployeeId()==1))
			informationService.delete(u);
		return "redirect:/InforMation/list";
	}

	@RequestMapping("/toSave")
	public String toSave() {
		return "/information/save";
	}

	@RequestMapping("/list")
	public String list(String showPage,Model model) {
		int pageSize=10;
		int recordCount; //总记录数
		int pageCount;   //总页数
		List<Information> ifList = informationService.findAll();
		recordCount=ifList.size();
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
		List<Information>informs=informationService.findPart(size,pageSize);
		model.addAttribute("informList",informs);
		return "/information/list";
	}

}

package org.CPIMS.controller;

import java.util.List;
import org.CPIMS.domain.Post;
import org.CPIMS.service.DepartmentService;
import org.CPIMS.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postService;
	@Autowired
	DepartmentService departmentService;

	@RequestMapping("/save")
	public String addPost(Post d) {
		Post temp = postService.get(d.getPostNum());
		if (temp != null) {
			temp.setDepartmentName(d.getDepartmentName());
			temp.setPostName(d.getPostName());
			postService.reset(temp);
		} else {
			postService.addPost(d);
		}
		departmentService.addDepartmentPostCount(departmentService.get(d.getDepartmentId()));
		return "redirect:/post/list";
	}

	@RequestMapping("/edit")
	public String edit(Post u) {
		Post p = postService.get(u.getPostId());
		p.setPostName(u.getPostName());
		p.setDepartmentId(u.getDepartmentId());
		p.setDepartmentName(u.getDepartmentName());
		postService.update(p);
		return "redirect:/post/list";
	}

	@RequestMapping("/delete")
	public String delete(Long id) {
		Post d = postService.get(id);
		if (d != null) {
			postService.delete(d);
			departmentService.reduceDepartmentPostCount(departmentService.get(d.getDepartmentId()));
		}
		return "redirect:/post/list";
	}

	@RequestMapping("/toSave")
	public String toSave(Model model) {
		model.addAttribute("postNumList", postService.findAllNum());
		model.addAttribute("deList", departmentService.findAll());
		return "/post/save";
	}

	@RequestMapping("/toEdit")
	public String toEdit(Long id, Model model) {
		Post post = postService.get(id);
		model.addAttribute("post", post);
		model.addAttribute("deList", departmentService.findAll());
		return "/post/edit";
	}

	@RequestMapping("/list")
	public String list(String showPage, Model model) {
		int pageSize = 10;
		int recordCount; // 总记录数
		int pageCount; // 总页数
		List<Post> postList = postService.findAll();
		recordCount = postList.size();
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
		List<Post> posts = postService.findPart(size, pageSize);
		model.addAttribute("postList", posts);
		return "post/list";
	}

}

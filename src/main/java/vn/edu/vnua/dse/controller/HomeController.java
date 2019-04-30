package vn.edu.vnua.dse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.vnua.dse.entity.Post;
import vn.edu.vnua.dse.service.PostService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "home";
	}

	@RequestMapping(value = { "home" }, method = RequestMethod.GET)
	public String homePage(Model model) {

		int pendingPosts = 0;
		int approvedPosts = 0;
		List<Post> listLimitPublishedPost = new ArrayList<Post>();

		// lay so luong bai dang cho duyet va so luong bai da duyet
		try {
			pendingPosts = postService.getPendingPost() != null
					? postService.getPendingPost().size() > 0 ? postService.getPendingPost().size() : 0
					: 0;
			approvedPosts = postService.getApprovedPost() != null
					? postService.getApprovedPost().size() > 0 ? postService.getApprovedPost().size() : 0
					: 0;
			listLimitPublishedPost = postService.getLimitPostPublished(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("pendingPosts", pendingPosts);
		model.addAttribute("approvedPosts", approvedPosts);
		model.addAttribute("listPublishedPost", listLimitPublishedPost);
		
		return "home";
	}

	@RequestMapping(value = { "/contactus" }, method = RequestMethod.GET)
	public String contactusPage(Model model) {
		model.addAttribute("address", "Vietnam");
		model.addAttribute("phone", "...");
		model.addAttribute("email", "...");
		return "contactusPage";
	}
}

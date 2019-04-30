package vn.edu.vnua.dse.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.vnua.dse.entity.Categories;
import vn.edu.vnua.dse.entity.Post;
import vn.edu.vnua.dse.service.CategoriesService;
import vn.edu.vnua.dse.service.PostService;

@Controller
public class PostController {

	@Autowired
	private CategoriesService categoriesService;

	@Autowired
	private PostService postService;

	@RequestMapping(value = { "/post" }, method = RequestMethod.GET)
	public String newpostPage(Model model) {
		// Get all catergories
		List<Categories> listAllCatergories = new ArrayList<Categories>();
		try {
			listAllCatergories = categoriesService.getAllCategories(-1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("titleContent", "Thêm bài viết");
		model.addAttribute("listAllCatergories", listAllCatergories);
		return "post";
	}

	@RequestMapping(value = { "/post" }, method = RequestMethod.POST)
	public ModelAndView createdPost(Post post, HttpServletRequest request) {

		// Get username
		String author;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			author = ((UserDetails) principal).getUsername();
			post.setAuthor(author);
			post.setEditor(author);
		}

		// get categoriesId
		int categoriesId = request.getParameter("categoriesId") != null
				? Integer.parseInt(request.getParameter("categoriesId").toString())
				: 0;

		if (categoriesId == 0) {
			return new ModelAndView("redirect:/post");
		}

		// get categories by id
		Categories categories = categoriesService.getCategoriresById(categoriesId);

		// Xy ly url

		post.setCategories(categories);
		try {
			postService.createdPost(post);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ModelAndView("redirect:/home");
	}

	/**
	 * 
	 * @param postId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editpost{postId}", method = RequestMethod.GET)
	public String editPost(int postId, Model model) {
		// Get all catergories
		List<Categories> listAllCatergories = new ArrayList<Categories>();
		try {
			listAllCatergories = categoriesService.getAllCategories(-1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("titleContent", "Thêm bài viết");
		model.addAttribute("listAllCatergories", listAllCatergories);
		model.addAttribute("titleContent", "Sửa bài viêt");
		model.addAttribute("title", "Tra cứu danh sách trúng tuyển và thủ tục nhập học");
		model.addAttribute("content",
				"<p style=\"text-align:justify\">Đội ngũ giảng vi&ecirc;n &ndash; chuy&ecirc;n gia &ndash; nh&agrave; khoa học lu&ocirc;n đ&oacute;ng vai tr&ograve; quan trọng trong qu&aacute; tr&igrave;nh ph&aacute;t triển của Học viện N&ocirc;ng nghiệp Việt Nam. 80% giảng vi&ecirc;n được đ&agrave;o tạo ch&iacute;nh quy v&agrave; tu nghiệp h&agrave;ng năm tại c&aacute;c nước ph&aacute;t triển như Mỹ, Ph&aacute;p, Đức, Bỉ, H&agrave; Lan, Nhật Bản, &Uacute;c&hellip; c&ugrave;ng với đ&oacute; l&agrave; rất nhiều giảng vi&ecirc;n quốc tế đang thỉnh giảng v&agrave; nghi&ecirc;n cứu khoa học tại Học viện N&ocirc;ng nghiệp Việt Nam.</p>\r\n"
						+ " \r\n"
						+ " <p style=\"text-align:center\"><img alt=\"\" src=\"http://localhost:8080/tuyensinhhvnapi/resources/upload/images/Picture5.png\" style=\"height:215px; width:350px\" /></p>\r\n"
						+ " \r\n"
						+ " <p style=\"text-align:center\"><img alt=\"\" src=\"http://localhost:8080/tuyensinhhvnapi/resources/upload/images/Picture6.png\" style=\"height:234px; width:350px\" /></p>\r\n"
						+ " \r\n"
						+ " <p style=\"text-align:center\"><img alt=\"\" src=\"http://localhost:8080/tuyensinhhvnapi/resources/upload/images/ncs-480x300.jpg\" style=\"height:219px; width:350px\" /></p>\r\n"
						+ " \r\n"
						+ " <p style=\"text-align:center\"><img alt=\"\" src=\"http://localhost:8080/tuyensinhhvnapi/resources/upload/images/thacsy-480x300.jpg\" style=\"height:219px; width:350px\" /></p>\r\n"
						+ " \r\n"
						+ " <p>Tổng số c&aacute;n bộ vi&ecirc;n chức đang l&agrave;m việc tại Học viện N&ocirc;ng nghiệp Việt Nam: 1.368 người.</p>\r\n"
						+ " \r\n" + " <p>Trong đ&oacute;:</p>\r\n" + " \r\n" + " <ul>\r\n"
						+ " 	<li>728 giảng vi&ecirc;n</li>\r\n" + " 	<li>Tr&ecirc;n 100 Gi&aacute;o sư, PGS</li>\r\n"
						+ " 	<li>290 Tiến sĩ</li>\r\n"
						+ " 	<li>105 Nh&agrave; gi&aacute;o nh&acirc;n d&acirc;n, Nh&agrave; gi&aacute;o ưu t&uacute;, Anh h&ugrave;ng lao động</li>\r\n"
						+ " </ul>\r\n" + " ");
		model.addAttribute("author", "tác giả bài viết");
		return "post";
	}

	@RequestMapping(value = "/editpost{id}", method = RequestMethod.POST)
	public String editPost() {
		return "home";
	}

	@RequestMapping(value = { "admin/pendingpost" }, method = RequestMethod.GET)
	public String pendingPosttPage(Model model) {
		List<Post> listAllPendingPost = new ArrayList<Post>();
		List<Post> listLimitPendingPost = new ArrayList<Post>();

		try {
			// lay danh sach 10 bai viet dang cho duyet moi nhat tu db
			listAllPendingPost = postService.getPendingPost();

			// lay 10 bai viet dang cho duyet
			listLimitPendingPost = postService.getLimitPendingPost(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int numberPage = (int) Math.ceil(listAllPendingPost.size() / 10.0);

		model.addAttribute("listPendingPost", listLimitPendingPost);
		model.addAttribute("totalRecord", listAllPendingPost.size());
		model.addAttribute("numberPage", numberPage);

		return "admin/pendingpost";
	}

	@RequestMapping(value = { "admin/approvedpost" }, method = RequestMethod.GET)
	public String approvedPostPage(Model model) {
		List<Post> listAllApprovedPost = new ArrayList<Post>();
		List<Post> listLimitApprovedPost = new ArrayList<Post>();

		try {
			// lay danh sach 10 bai viet dang cho duyet moi nhat tu db
			listAllApprovedPost = postService.getApprovedPost();

			// lay 10 bai viet dang cho duyet
			listLimitApprovedPost = postService.getLimitApprovedPost(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int numberPage = (int) Math.ceil(listAllApprovedPost.size() / 10.0);

		model.addAttribute("listApprovedPost", listLimitApprovedPost);
		model.addAttribute("totalRecord", listAllApprovedPost.size());
		model.addAttribute("numberPage", numberPage);

		return "admin/approvedpost";
	}

	@RequestMapping(value = { "admin/postpublished" }, method = RequestMethod.GET)
	public String postPublishedPage(Model model) {

		List<Post> listAllPublishedPost = new ArrayList<Post>();
		List<Post> listLimitPublishedPost = new ArrayList<Post>();

		try {
			// lay danh sach 10 bai viet da xuat ban moi nhat tu db
			listAllPublishedPost = postService.getPostPublished();

			// lay 10 bai viet da xuat ban
			listLimitPublishedPost = postService.getLimitPostPublished(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int numberPage = (int) Math.ceil(listAllPublishedPost.size() / 10.0);

		model.addAttribute("listPublishedPost", listLimitPublishedPost);
		model.addAttribute("totalRecord", listAllPublishedPost.size());
		model.addAttribute("numberPage", numberPage);

		return "admin/postpublished";
	}

	/**
	 * Controller duyet bai viet
	 * 
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = { "admin/pendingpost/approved" }, method = RequestMethod.POST)
	public String approved(HttpServletRequest request) {

		// get postId
		int postId = request.getParameter("postId") != null
				? Integer.parseInt(request.getParameter("postId").toString())
				: 0;

		// Get user
		String approvedUser = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			approvedUser = ((UserDetails) principal).getUsername();
		}
		
		// update
		try {
			postService.approved(postId, approvedUser);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:/admin/pendingpost";
	}
	
	/**
	 * Controller duyet bai viet
	 * 
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = { "admin/pendingpost/unapproved" }, method = RequestMethod.POST)
	public String unapproved(HttpServletRequest request) {

		// get postId
		int postId = request.getParameter("postId") != null
				? Integer.parseInt(request.getParameter("postId").toString())
				: 0;

		// Get user
		String unapprovedUser = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			unapprovedUser = ((UserDetails) principal).getUsername();
		}
		
		// go bai viet
		try {
			postService.unapproved(postId, unapprovedUser);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:/admin/pendingpost";
	}
}

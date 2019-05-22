package vn.edu.vnua.dse.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.vnua.dse.common.Common;
import vn.edu.vnua.dse.common.CommonConst;
import vn.edu.vnua.dse.common.CommonUtils;
import vn.edu.vnua.dse.common.DateUtils;
import vn.edu.vnua.dse.entity.Categories;
import vn.edu.vnua.dse.entity.Post;
import vn.edu.vnua.dse.entity.User;
import vn.edu.vnua.dse.service.CategoriesService;
import vn.edu.vnua.dse.service.PostService;
import vn.edu.vnua.dse.service.UserService;

@Controller
@RequestMapping(value = "/post")
public class PostController {

	@Autowired
	private CategoriesService categoriesService;

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
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
		return "post/add";
	}

	/**
	 * Controlelr them moi bai viet
	 * 
	 * @param post
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public ModelAndView createdPost(@ModelAttribute("Post") Post post, BindingResult result,
			HttpServletRequest request) {

		// Get username
		String author = null;
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
			return new ModelAndView("redirect:/post/add");
		}

		// get categories by id
		Categories categories = categoriesService.getCategoriresById(categoriesId);
		post.setCategories(categories);

		// them
		User user = new User();
		try {
			user = userService.getUserByUsername(author).get(0);
			post.setUser(user);
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_EDITOR)
					|| user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {
				post.setStatus(true);
				post.setPublishedDate(DateUtils.stringToDateTime(request.getParameter("publishedDate")));
			} else {
				post.setStatus(false);
			}
			postService.createdPost(post);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ModelAndView("redirect:/post/add");
	}

	/**
	 * Controller chuyen huong toi trang sua bai viet
	 * 
	 * @param postId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPost(int postId) {

		return "redirect:" + "/post/add";
	}

	/**
	 * Controller sua bai viet
	 * 
	 * @param postId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String editPost(int postId, ModelMap model) {

		List<Categories> listAllCatergories = new ArrayList<Categories>();
		Post post = new Post();

		try {
			// Lay tat ca chuyen muc
			listAllCatergories = categoriesService.getAllCategories(-1);
			// lay bai viet theo id
			post = postService.getPostById(postId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("post", post);
		model.addAttribute("listAllCatergories", listAllCatergories);

		return "post/update";
	}

	/**
	 * Controller xua ly su kien click vao menu bai cho duyet
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/pending" }, method = RequestMethod.GET)
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

		return "post/pending";
	}

	@RequestMapping(value = { "/approved" }, method = RequestMethod.GET)
	public String approvedPostPage(Model model) {
		List<Post> listAllApprovedPost = new ArrayList<Post>();
		List<Post> listLimitApprovedPost = new ArrayList<Post>();

		try {
			// lay danh sach tatc ca bai viet dang cho duyet tu db
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

		return "post/approved";
	}

	@RequestMapping(value = { "/published" }, method = RequestMethod.GET)
	public String postPublishedPage(Model model) {

		List<Post> listAllPublishedPost = new ArrayList<Post>();
//		List<Post> listLimitPublishedPost = new ArrayList<Post>();

		try {
			// lay danh sach tat ca bai viet da xuat ban moi nhat tu db
			listAllPublishedPost = postService.getPostPublished();

			// lay 10 bai viet da xuat ban
//			listLimitPublishedPost = postService.getLimitPostPublished(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		int numberPage = (int) Math.ceil(listAllPublishedPost.size() / 10.0);

		model.addAttribute("listPublishedPost", listAllPublishedPost);
		model.addAttribute("totalRecord", listAllPublishedPost.size());
//		model.addAttribute("numberPage", numberPage);

		return "post/published";
	}

	/**
	 * Controller duyet bai viet, chi chap nhan quyen editor
	 * 
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = { "editor/approved" }, method = RequestMethod.POST)
	public String approved(HttpServletRequest request) {

		// Get user
		User user = new User();
		String approvedUser = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			approvedUser = ((UserDetails) principal).getUsername();
		}

		try {
			user = userService.getUserByUsername(approvedUser).get(0);
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_EDITOR)
					|| user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {
				// get postId
				int postId = request.getParameter("postId") != null
						? Integer.parseInt(request.getParameter("postId").toString())
						: 0;

				// set thoi gian dang bai viet
				Date publishedDate = request.getParameter("publishedDate") != null
						? !"".equals(request.getParameter("publishedDate"))
								? DateUtils.stringToDateTime(request.getParameter("publishedDate"))
								: new Date()
						: new Date();

				// duyet bai viet
				postService.approved(postId, approvedUser, publishedDate);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:post/pending";
	}

	/**
	 * Controller go bai viet, chi chap nhan quyen editor
	 * 
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = { "editor/unapproved" }, method = RequestMethod.POST)
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

		return "redirect:/post/pending";
	}

	/**
	 * Controller sua bai viet
	 * 
	 * @param post
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/updated" }, method = RequestMethod.POST)
	public ModelAndView updatedPost(@ModelAttribute("Post") Post post, BindingResult result,
			HttpServletRequest request) {

		// Get user hien tai trong he thong
		String userCurrent;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userCurrent = ((UserDetails) principal).getUsername();
			post.setUpdatedUser(userCurrent);
		}

		// get categoriesId
		int categoriesId = request.getParameter("categoriesId") != null
				? Integer.parseInt(request.getParameter("categoriesId").toString())
				: 0;

		if (categoriesId == 0) {
			return new ModelAndView("redirect:" + "/post/add");
		}

		// get categories by id
		Categories categories = categoriesService.getCategoriresById(categoriesId);

		// get publishedDate
		String timestamp = request.getParameter("publishedDate");
		post.setPublishedDate(DateUtils.stringToDateTime(timestamp));

		post.setCategories(categories);
		try {
			postService.updatePost(post);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ModelAndView("redirect:" + "/post/pending");
	}

	/**
	 * lay noi dung bai viet theo id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String getContentPostById(int postId, HttpServletRequest request) {
		// get postId
		int id = request.getParameter("postId") != null ? Integer.parseInt(request.getParameter("postId").toString())
				: 0;

		// get post by id
		Post post = new Post();

		try {
			post = postService.getPostById(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		return post.getContent();
	}

	/**
	 * Controller bo go bai viet, chi chap nhan quyen editor va admin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/editor/public" }, method = RequestMethod.POST)
	public String unpublic(HttpServletRequest request) {

		// Get user
		String unapprovedUser = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			unapprovedUser = ((UserDetails) principal).getUsername();
		}

		// check role user
		User user = new User();
		try {
			user = userService.getUserByUsername(unapprovedUser).get(0);
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_EDITOR)
					|| user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {

				// get postId
				int postId = request.getParameter("postId") != null
						? Integer.parseInt(request.getParameter("postId").toString())
						: 0;

				// bo go bai viet
				postService.publicPost(postId);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "post/unpublic";
	}

	@RequestMapping(value = { "/unpublic" }, method = RequestMethod.GET)
	public String unPublicVideo(Model model) {

		List<Post> listAllPost = new ArrayList<Post>();
		List<Post> listLimitPost = new ArrayList<Post>();

		try {
			// lay danh sach tat ca bai viet da bi go moi nhat tu db
			listAllPost = postService.getPostUnPublic();

			// lay 5 video da bi go
			listLimitPost = postService.getLimitPostUnPublic(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int numberPage = (int) Math.ceil(listAllPost.size() / 5.0);

		model.addAttribute("listPostUnPublic", listLimitPost);
		model.addAttribute("totalRecord", listAllPost.size());
		model.addAttribute("numberPage", numberPage);

		return "post/unpublic";
	}

}

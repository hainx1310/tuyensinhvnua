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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vnua.dse.common.CommonConst;
import vn.edu.vnua.dse.common.DateUtils;
import vn.edu.vnua.dse.entity.Categories;
import vn.edu.vnua.dse.entity.Post;
import vn.edu.vnua.dse.entity.User;
import vn.edu.vnua.dse.service.CategoriesService;
import vn.edu.vnua.dse.service.PostService;
import vn.edu.vnua.dse.service.UserService;

@Controller
@RequestMapping(value = "/bai-viet")
public class PostController {

	@Autowired
	private CategoriesService categoriesService;

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/them-moi-bai-viet" }, method = RequestMethod.GET)
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
		model.addAttribute("activeAddNewPost", "active");
		return "bai-viet/them-moi-bai-viet";
	}

	/**
	 * Controlelr them moi bai viet
	 * 
	 * @param post
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/them-moi-bai-viet" }, method = RequestMethod.POST)
	public ModelAndView createdPost(@ModelAttribute("Post") Post post, BindingResult result, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

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
			return new ModelAndView("redirect:/bai-viet/them-moi-bai-viet");
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
			redirectAttributes.addFlashAttribute("msg", "Thêm bài viết thành công!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ModelAndView("redirect:/bai-viet/them-moi-bai-viet");
	}

	/**
	 * Controller chuyen huong toi trang sua bai viet
	 * 
	 * @param postId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sua-bai-viet", method = RequestMethod.GET)
	public String editPost(int postId) {

		return "redirect:" + "/bai-viet/them-moi-bai-viet";
	}

	/**
	 * Controller sua bai viet
	 * 
	 * @param postId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/cap-nhat-bai-viet", method = RequestMethod.GET)
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

		return "bai-viet/cap-nhat-bai-viet";
	}

	/**
	 * Phương thức xóa bỏ 1 bai viet
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		int postId;
		postId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id").toString()) : 0;
		try {
			postService.deletePost(postId);
			redirectAttributes.addFlashAttribute("msg", "Xóa bài viết thành công!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return new ModelAndView("redirect:/bai-viet/bai-cho-duyet");
	}

	/**
	 * Controller xua ly su kien click vao menu bai cho duyet
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/bai-cho-duyet" }, method = RequestMethod.GET)
	public String pendingPosttPage(Model model) {
		List<Post> listAllPendingPost = new ArrayList<Post>();
		List<Post> listLimitPendingPost = new ArrayList<Post>();

		String msg = (String) model.asMap().get("msg");

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
		model.addAttribute("activePendingPage", "active");
		model.addAttribute("msg", msg);

		return "bai-viet/bai-cho-duyet";
	}

	@RequestMapping(value = { "/bai-cho-dang" }, method = RequestMethod.GET)
	public String approvedPostPage(Model model) {
		List<Post> listAllApprovedPost = new ArrayList<Post>();
		List<Post> listLimitApprovedPost = new ArrayList<Post>();

		String msg = (String) model.asMap().get("msg");

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
		model.addAttribute("activeApprovedPage", "active");
		model.addAttribute("msg", msg);

		return "bai-viet/bai-da-duyet";
	}

	@RequestMapping(value = { "/bai-da-dang" }, method = RequestMethod.GET)
	public String postPublishedPage(Model model, HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {
		User user = new User();
		List<Post> listAllPublishedPost = new ArrayList<Post>();
		int postByUserId = 0;
		int totalAllRecord = 0;
		int totalRecord = 0;
		int numberPage = 0;
		List<Categories> listCategories = new ArrayList<Categories>();
		List<Post> listLimitPublishedPost = new ArrayList<Post>();
		String msg = (String) model.asMap().get("msg");

		// Get user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			user = userService.getUserByUsername(username).get(0);
		}

		try {
			// lay danh sach tat ca bai viet da xuat ban moi nhat tu db
			listAllPublishedPost = postService.getPostPublished();
			totalAllRecord = listAllPublishedPost.size();

			// lay tat ca chuyen muc
			listCategories = categoriesService.getAllCategories(-1);

			if (user != null) {
				postByUserId = postService.getPostIsPublishedByUserId(user.getId());
			}
			if (request.getParameter("bai-cua-toi") == null) {
				// lay 10 bai viet da xuat ban
				listLimitPublishedPost = postService.getLimitPostPublished(0, 5);
				numberPage = (int) Math.ceil(listAllPublishedPost.size() / 5.0);
				totalRecord = listAllPublishedPost.size();
				model.addAttribute("allPost", true);
			} else {
				if (user != null) {
					listLimitPublishedPost = postService.getLimitPostIsPublishedByUserId(0, 5, user.getId());
					model.addAttribute("bai-cua-toi", true);
					totalRecord = postByUserId;
					numberPage = (int) Math.ceil(postByUserId / 5.0);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("listPublishedPost", listLimitPublishedPost);
		model.addAttribute("totalAllRecord", totalAllRecord);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("postByUserId", postByUserId);
		model.addAttribute("numberPage", numberPage);
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("activePublishedPage", "active");
		model.addAttribute("msg", msg);
		return "bai-viet/bai-da-dang";
	}

	/**
	 * Controller phan trang bai viet da dang
	 * 
	 * @param startIndex
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getMorePost", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String postPublishedById(@RequestParam int startIndex, HttpServletRequest request) {
		User user = new User();
		List<Post> listResult = new ArrayList<Post>();
		String html = "";
		int i = startIndex + 1;

		// Get user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			user = userService.getUserByUsername(username).get(0);
		}

		try {
			if (request.getParameter("postOfMe") == null) {
				// truong hop phan trang tat ca
				listResult = postService.getLimitPostPublished(startIndex, 5);
			} else {
				// truong hop phan trang bai cua toi
				if (user != null) {
					listResult = postService.getLimitPostIsPublishedByUserId(startIndex, 5, user.getId());
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		for (Post item : listResult) {
			html += "<tr role='row' class='odd'>";
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)
					|| user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {
				html += "<td><input type=\"checkbox\" class=\"custom-control-input\" id=\"defaultUnchecked\"></td>";
			}
			html += "<td class=''>" + (i++) + "</td>";
			html += "<td style=\"max-width: 400px\" class=\"\"><a href=\"#\"";
			html += " onclick='viewPost(" + item.getId() + ",\"" + item.getTitle() + "\")'";
			html += " title=\"Xem bài viết\">" + item.getTitle() + "</a></td>";
			html += "<td class=\"sorting_1\">" + item.getCategories().getName() + "</td>";
			html += "<td>" + item.showPublishedDate() + "</td>";
			html += "<td>" + item.getAuthor() + "</td>";
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)
					|| user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {
				html += "<td style=\"text-align: center;\"><a href=\"#\"";
				html += " class=\"fa fa-remove\" title=\"Gỡ bài viết\"";
				html += " onclick='openModalUnpublicPost(" + item.getId() + ", \"" + item.getTitle() + "\")'></a></td>";
			}
			html += "</tr>";
		}

		return html + (i - 1);
	}

	/**
	 * Controller duyet bai viet, chi chap nhan quyen editor
	 * 
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = { "editor/approved" }, method = RequestMethod.POST)
	public String approved(HttpServletRequest request, final RedirectAttributes redirectAttributes) {

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
				redirectAttributes.addFlashAttribute("msg", "Duyệt bài viết thành công!");
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:/bai-viet/bai-cho-duyet";
	}

	/**
	 * Controller go bai viet, chi chap nhan quyen editor
	 * 
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = { "editor/unapproved" }, method = RequestMethod.POST)
	public String unapproved(HttpServletRequest request, final RedirectAttributes redirectAttributes) {

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
			redirectAttributes.addFlashAttribute("msg", "Gỡ bài viết thành công");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return request.getParameter("pendingpost") != null ? "redirect:/bai-viet/bai-cho-dang"
				: "redirect:/bai-viet/bai-da-dang";
	}

	/**
	 * Controller sua bai viet
	 * 
	 * @param post
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/cap-nhat-bai-viet" }, method = RequestMethod.POST)
	public ModelAndView updatedPost(@ModelAttribute("Post") Post post, BindingResult result, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

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
			return new ModelAndView("redirect:" + "/bai-viet/them-moi-bai-viet");
		}

		// get categories by id
		Categories categories = categoriesService.getCategoriresById(categoriesId);

		// get publishedDate
		String timestamp = request.getParameter("publishedDate");
		post.setPublishedDate(DateUtils.stringToDateTime(timestamp));

		post.setCategories(categories);
		try {
			postService.updatePost(post);
			redirectAttributes.addFlashAttribute("msg", "Cập nhật bài viết thành công!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ModelAndView("redirect:/bai-viet/bai-cho-duyet");
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

		return "<style> img { max-width: 367px;} </style>" + post.getContent().replaceAll("height", "");
	}

	/**
	 * Controller bo go bai viet, chi chap nhan quyen editor va admin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/editor/public" }, method = RequestMethod.POST)
	public String unpublic(HttpServletRequest request, final RedirectAttributes redirectAttributes) {

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
				redirectAttributes.addFlashAttribute("msg", "Bỏ gỡ bài viết thành công");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:/bai-viet/bai-da-go";
	}

	@RequestMapping(value = { "/bai-da-go" }, method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	public String unPublicVideo(HttpServletRequest request, Model model) {

		List<Post> listAllPost = new ArrayList<Post>();
		List<Post> listLimitPost = new ArrayList<Post>();

		String msg = (String) model.asMap().get("msg");

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
		model.addAttribute("activeUnPublicPage", "active");
		model.addAttribute("msg", msg);

		return "bai-viet/bai-da-go";
	}

}

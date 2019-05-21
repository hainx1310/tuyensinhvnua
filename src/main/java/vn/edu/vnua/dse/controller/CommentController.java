package vn.edu.vnua.dse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.edu.vnua.dse.common.CommonConst;
import vn.edu.vnua.dse.entity.Comment;
import vn.edu.vnua.dse.entity.User;
import vn.edu.vnua.dse.service.CommentService;
import vn.edu.vnua.dse.service.UserService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private UserService userService;

	/**
	 * Controller lay danh sach binh luan dang cho duyet
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/binh-luan/duyet-binh-luan")
	public String loadComment(ModelMap model) {

		List<Comment> listLimitCommentPending = new ArrayList<Comment>();
		List<Comment> listAllCommentPending = new ArrayList<Comment>();

		try {
			listLimitCommentPending = commentService.getLimitCommentPending(0);
			listAllCommentPending = commentService.getAllCommentPending();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		model.addAttribute("totalRecord", listAllCommentPending.size());
		model.addAttribute("listComment", listLimitCommentPending);
		model.addAttribute("pagesNumber", (int) Math.ceil(listAllCommentPending.size() / 10.0));

		return "binh-luan/duyet-binh-luan";
	}

	/**
	 * Controller lay danh sach binh luan da duoc duyet
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/binh-luan/da-duoc-duyet")
	public String loadCommentApproved(ModelMap model) {

		List<Comment> listLimitCommentApproved = new ArrayList<Comment>();
		List<Comment> listAllCommentApproved = new ArrayList<Comment>();

		try {
			listLimitCommentApproved = commentService.getLimitCommentAprroved(0);
			listAllCommentApproved = commentService.getAllCommentAprroved();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		model.addAttribute("totalRecord", listAllCommentApproved.size());
		model.addAttribute("listComment", listLimitCommentApproved);
		model.addAttribute("pagesNumber", (int) Math.ceil(listAllCommentApproved.size() / 5.0));

		return "binh-luan/da-duoc-duyet";
	}

	/**
	 * Controller lay danh sach binh luan khong duoc duyet
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/binh-luan/khong-duoc-duyet")
	public String loadCommentNotApproved(ModelMap model) {

		List<Comment> listLimitCommentNotApproved = new ArrayList<Comment>();
		List<Comment> listAllCommentNotApproved = new ArrayList<Comment>();

		try {
			listLimitCommentNotApproved = commentService.getLimitCommentNotAprroved(0);
			listAllCommentNotApproved = commentService.getAllCommentNotAprroved();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		model.addAttribute("totalRecord", listAllCommentNotApproved.size());
		model.addAttribute("listComment", listLimitCommentNotApproved);
		model.addAttribute("pagesNumber", (int) Math.ceil(listAllCommentNotApproved.size() / 5.0));

		return "binh-luan/khong-duoc-duyet";
	}

	/**
	 * Controller duyet binh luan, chi chap nhan quyen editor va admin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "binh-luan/editor/approved" }, method = RequestMethod.POST)
	public String approved(HttpServletRequest request) {

		// Get user
		String approvedUser = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			approvedUser = ((UserDetails) principal).getUsername();
		}

		// check role user
		User user = new User();
		try {
			user = userService.getUserByUsername(approvedUser).get(0);
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_EDITOR)
					|| user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {

				// get videoId
				int commentId = request.getParameter("commentId") != null
						? Integer.parseInt(request.getParameter("commentId").toString())
						: 0;

				// duyet binh luan
				commentService.approved(commentId, approvedUser);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:/binh-luan/duyet-binh-luan";
	}

	/**
	 * Controller khong duyet binh luan, chi chap nhan quyen editor va admin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "binh-luan/editor/unapproved" }, method = RequestMethod.POST)
	@ResponseBody
	public String unapproved(HttpServletRequest request) {

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

				// get videoId
				int commentId = request.getParameter("commentId") != null
						? Integer.parseInt(request.getParameter("commentId").toString())
						: 0;

				// go binh luan
				commentService.unapproved(commentId, unapprovedUser);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:/comment";
	}
}

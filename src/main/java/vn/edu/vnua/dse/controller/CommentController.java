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

	@RequestMapping(value = "/comment")
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

		return "comment";
	}

	/**
	 * Controller duyet binh luan, chi chap nhan quyen editor va admin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "editor/comment/approved" }, method = RequestMethod.POST)
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
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_EDITOR)||user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {

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

		return "redirect:/comment";
	}

	/**
	 * Controller go binh luan, chi chap nhan quyen editor va admin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "editor/comment/approved/unapproved" }, method = RequestMethod.POST)
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
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_EDITOR)||user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {

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

package vn.edu.vnua.dse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String loadComment(Model model) {

		List<Comment> listLimitCommentPending = new ArrayList<Comment>();
		List<Comment> listAllCommentPending = new ArrayList<Comment>();
		String msg = (String) model.asMap().get("msg");

		try {
			listLimitCommentPending = commentService.getLimitCommentPending(0);
			listAllCommentPending = commentService.getAllCommentPending();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		model.addAttribute("totalRecord", listAllCommentPending.size());
		model.addAttribute("listComment", listLimitCommentPending);
		model.addAttribute("pagesNumber", (int) Math.ceil(listAllCommentPending.size() / 5.0));
		model.addAttribute("activeApprovedComment", "active");
		model.addAttribute("activeApprovedComment", "active");
		model.addAttribute("msg", msg);

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
		model.addAttribute("activePublicComment", "active");

		return "binh-luan/da-duoc-duyet";
	}

	/**
	 * Controller lay danh sach binh luan khong duoc duyet
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/binh-luan/khong-duoc-duyet")
	public String loadCommentNotApproved(Model model) {

		List<Comment> listLimitCommentNotApproved = new ArrayList<Comment>();
		List<Comment> listAllCommentNotApproved = new ArrayList<Comment>();
		String msg = (String) model.asMap().get("msg");

		try {
			listLimitCommentNotApproved = commentService.getLimitCommentNotAprroved(0);
			listAllCommentNotApproved = commentService.getAllCommentNotAprroved();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		model.addAttribute("totalRecord", listAllCommentNotApproved.size());
		model.addAttribute("listComment", listLimitCommentNotApproved);
		model.addAttribute("pagesNumber", (int) Math.ceil(listAllCommentNotApproved.size() / 5.0));
		model.addAttribute("activeUnPublicComment", "active");
		model.addAttribute("msg", msg);

		return "binh-luan/khong-duoc-duyet";
	}

	/**
	 * Controller duyet binh luan, chi chap nhan quyen editor va admin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "binh-luan/editor/approved" }, method = RequestMethod.POST)
	public String approved(HttpServletRequest request, final RedirectAttributes redirectAttributes) {

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

				// get commentId
				int commentId = request.getParameter("commentId") != null
						? Integer.parseInt(request.getParameter("commentId").toString())
						: 0;

				// duyet binh luan
				commentService.approved(commentId, approvedUser);
				redirectAttributes.addFlashAttribute("msg", "Duyệt bình luận thành công!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return request.getParameter("unapporved") != null ? "redirect:/binh-luan/khong-duoc-duyet"
				: "redirect:/binh-luan/duyet-binh-luan";
	}

	/**
	 * Controller khong duyet binh luan, chi chap nhan quyen editor va admin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "binh-luan/editor/unapproved" }, method = RequestMethod.POST)
	public String unapproved(HttpServletRequest request, final RedirectAttributes redirectAttributes) {

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
				redirectAttributes.addFlashAttribute("msg",
						"Thành công! Bình luận đã được chuyển đến mục không được duyệt.");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return request.getParameter("approved") != null ? "redirect:/binh-luan/da-duoc-duyet"
				: "redirect:/binh-luan/duyet-binh-luan";
	}

	/**
	 * Controller lấy ra 5 binh luan da duoc duyet tiep theo
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "binh-luan/editor/approved/get", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String getCommentApprovedLimit(@RequestParam int startIndex) {

		List<Comment> listComment = new ArrayList<Comment>();
		String html = "";
		int i = startIndex + 1;
		int j = 1;
		try {
			listComment = commentService.getLimitCommentAprroved(startIndex);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		for (Comment item : listComment) {
			html += "<tr role='row' class='odd'>";
			html += "<td><input type=\"checkbox\" class=\"custom-control-input\" id=\"defaultUnchecked\"></td>";
			html += "<td class=''>" + (i++) + "</td>";
			html += "<td style=\"max-width: 400px\" class=\"sorting_1\">" + item.getpost().getTitle() + "</td>";
			html += "<td style=\"max-width: 200px\">" + item.getComment() + "</td>";
			html += "<td>" + item.getName() + "</td>";
			html += "<td>" + item.showCreatedDate() + "</td>";
			html += "<td style=\"text-align: center\">";
			html += "<form id=\"form-unapproved-comment-" + j + "\" action=\"editor/unapproved\" ";
			html += "method=\"POST\"> <input name=\"commentId\" type=\"hidden\" ";
			html += "value=\"" + item.getId() + "\"><input name=\"approved\" type=\"hidden\" value=\"approved\">";
			html += "<a href=\"#\" class=\"fa fa-remove\" title=\"Bỏ duyệt\" ";
			html += "onclick='unapprovedComment(\"" + (j++) + "\")'></a></form></td>";
			html += "</tr>";
		}
		return html + (i - 1);
	}

	/**
	 * Controller lấy ra 5 binh luan da duoc duyet tiep theo
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "binh-luan/editor/notapproved/get", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String getCommentNotApprovedLimit(@RequestParam int startIndex) {

		List<Comment> listComment = new ArrayList<Comment>();
		String html = "";
		int i = startIndex + 1;
		int j = 1;
		try {
			listComment = commentService.getLimitCommentNotAprroved(startIndex);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		for (Comment item : listComment) {
			html += "<tr role='row' class='odd'>";
			html += "<td><input type=\"checkbox\" class=\"custom-control-input\" id=\"defaultUnchecked\"></td>";
			html += "<td class=''>" + (i++) + "</td>";
			html += "<td style=\"max-width: 400px\" class=\"sorting_1\">" + item.getpost().getTitle() + "</td>";
			html += "<td style=\"max-width: 200px\">" + item.getComment() + "</td>";
			html += "<td>" + item.getName() + "</td>";
			html += "<td>" + item.showCreatedDate() + "</td>";
			html += "<td style=\"text-align: center;\">";
			html += "<form id=\"form-approved-comment-" + j + "\" action=\"editor/approved\" ";
			html += "method=\"POST\"> <input name=\"commentId\" type=\"hidden\" ";
			html += "value=\"" + item.getId() + "\"><input name=\"unapporved\" type=\"hidden\" value=\"unapporved\">";
			html += "<a href=\"#\" class=\"fa fa-check\" title=\"Duyệt\" ";
			html += "onclick='approvedComment(\"" + (j++) + "\")'></a></form></td>";
			html += "</tr>";
		}
		return html + (i - 1);
	}

	/**
	 * Controller lấy ra 5 binh luan dang cho duyet tiep theo
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "binh-luan/editor/pending/get", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String getCommentPendingLimit(@RequestParam int startIndex) {

		List<Comment> listComment = new ArrayList<Comment>();
		String html = "";
		int i = startIndex + 1;
		int j = 1;
		try {
			listComment = commentService.getLimitCommentPending(startIndex);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		for (Comment item : listComment) {
			html += "<tr role='row' class='odd'>";
			html += "<td><input type=\"checkbox\" class=\"custom-control-input\" id=\"defaultUnchecked\"></td>";
			html += "<td class=''>" + (i++) + "</td>";
			html += "<td style=\"max-width: 400px\" class=\"sorting_1\">" + item.getpost().getTitle() + "</td>";
			html += "<td style=\"max-width: 200px\">" + item.getComment() + "</td>";
			html += "<td>" + item.getName() + "</td>";
			html += "<td>" + item.showCreatedDate() + "</td>";
			html += "<td style=\"text-align: center\"> ";
			html += "<form style=\"display: inline-block;\" id=\"form-approved-comment-" + j;
			html += "\" action=\"editor/approved\" ";
			html += "method=\"POST\"> <input name=\"commentId\" type=\"hidden\" ";
			html += "value=\"" + item.getId() + "\">";
			html += "<a href=\"#\" class=\"fa fa-check\" title=\"Duyệt\" ";
			html += "onclick='approvedComment(\"" + j + "\")'></a></form>";
			html += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			html += "<form style=\"display: inline-block;\" id=\"form-unapproved-comment-" + j;
			html += "\" action=\"editor/unapproved\" ";
			html += "method=\"POST\"> <input name=\"commentId\" type=\"hidden\" ";
			html += "value=\"" + item.getId() + "\">";
			html += "<a href=\"#\" class=\"fa fa-remove\" title=\"Bỏ duyệt\" ";
			html += "onclick='unapprovedComment(\"" + (j++) + "\")'></a></form></td";
			html += "</tr>";
		}
		return html + (i - 1);
	}

}

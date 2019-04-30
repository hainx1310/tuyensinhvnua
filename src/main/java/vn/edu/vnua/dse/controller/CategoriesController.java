package vn.edu.vnua.dse.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.vnua.dse.entity.Categories;
import vn.edu.vnua.dse.service.CategoriesService;

@Controller
@RequestMapping("/admin")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;

	/**
	 * Controller lấy ra danh sách tất cả chuyên mục
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String getAllCategorires(Model model) {

		List<Categories> listCategories = new ArrayList<Categories>();
		List<Categories> listAllCategories = new ArrayList<Categories>();
		int pagesNumber = 0;
		int totalrRecord = 0;
		try {
			listCategories = categoriesService.getAllCategories(0);
			listAllCategories = categoriesService.getAllCategories(-1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		pagesNumber = (int) Math.ceil(listAllCategories.size() / 10.0);
		totalrRecord = listAllCategories.size();
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("pagesNumber", pagesNumber);
		model.addAttribute("totalrRecord", totalrRecord);

		return "admin/categories";
	}

	/**
	 * Controller thêm mới một chuyên mục
	 * 
	 * @param categories
	 * @return
	 */
	@RequestMapping(value = "/AddCategories", method = RequestMethod.POST)
	public ModelAndView createCategory(Categories categories) {
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			categories.setCreatedUser(username);
		}

		try {
			categoriesService.addCategories(categories);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ModelAndView("redirect:" + "/admin/categories");
	}

	/**
	 * Controller cập nhật một chuyên mục
	 * 
	 * @return
	 */
	@RequestMapping(value = "/EditCategories", method = RequestMethod.POST)
	public ModelAndView updateCategories(Categories categories) {

		// Get username
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			categories.setUpdatedUser(username);
		}

		try {
			categoriesService.updateCategories(categories);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return new ModelAndView("redirect:" + "/admin/categories");
	}

	/**
	 * Phương thức xóa bỏ 1 chuyên mục
	 * 
	 * @param categories
	 * @return
	 */
	@RequestMapping(value = "/DeleteCategories", method = RequestMethod.POST)
	public ModelAndView deleteCategories(HttpServletRequest request) {
		int categoriesId;
		categoriesId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id").toString()) : 0;
		try {
			categoriesService.deleteCategories(categoriesId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return new ModelAndView("redirect:" + "/admin/categories");
	}

	/**
	 * Phuong thuc thay doi trang thai cua categories
	 * 
	 * @param request
	 */
	@RequestMapping(value = "/changeStatusCategories", method = RequestMethod.POST)
	public String changeStatusCategories(HttpServletRequest request) {
		int categoriesId;
		String username = null;

		// get categoriesId
		categoriesId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id").toString()) : 0;
		boolean status = request.getParameter("status") != null
				? "true".equals(request.getParameter("status")) ? false : true
				: false;

		// Get username
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}

		try {
			categoriesService.changeStatusCategories(categoriesId, status, username);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "redirect:/admin/categories";
	}

	/**
	 * Controller lấy ra 10 categories tiep theo
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getCategoriresLimit", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String getCategoriresLimit(@RequestParam int startIndex) {

		List<Categories> listCategories = new ArrayList<Categories>();
		String html = "";
		int i = startIndex + 1;
		try {
			listCategories = categoriesService.getAllCategories(startIndex);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		for (Categories item : listCategories) {
			html += "<tr role='row' class='odd'>";
			html += "<td><input type=\"checkbox\" class=\"custom-control-input\" id=\"defaultUnchecked\"></td>";
			html += "<td class=''>" + (i++) + "</td>";
			html += "<td id='categories-name' class='sorting_1'>" + item.getName() + "</td>";
			html += "<td id='categories-status'>" + (item.isStatus() == true ? "Kích hoạt" : "Khóa") + "</td>";
			html += "<td id='categories-created-date'>" + item.getCreatedDate() + "</td>";
			html += "<td id='categories-created-user'>" + (item.getCreatedUser() == null ? "" : item.getCreatedUser())
					+ "</td>";
			html += "<td id='categories-updated-date'>" + (item.getUpdatedDate() == null ? "" : item.getUpdatedDate())
					+ "</td>";
			html += "<td id='categories-updated-user'>" + (item.getUpdatedUser() == null ? "" : item.getUpdatedUser())
					+ "</td>";
			html += "<td><a id='changeStatusCategories' onclick='openModalChangeStatusCategories(" + item.getId() + ", "
					+ item.isStatus() + ")' href='#' class = "
					+ (item.isStatus() == true ? "\"fa fa-toggle-on\"" : "\"fa fa-toggle-off\"")
					+ "></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='openModalUpdateCategories("
					+ item.getId() + ", \"" + item.getName() + "\", " + item.isStatus()
					+ ")' href=\"#\" class = \"fa fa-pencil\"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a "
					+ "onclick='openModalDeleteCategories(" + item.getId() + ", \"" + item.getName() + "\")' "
					+ "href=\"#\" class = \"fa fa-trash-o\"></a></td>";
			html += "</tr>";
		}
		return html + (i - 1);
	}
}

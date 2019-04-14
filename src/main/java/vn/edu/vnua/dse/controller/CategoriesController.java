package vn.edu.vnua.dse.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.vnua.dse.entity.Categories;
import vn.edu.vnua.dse.service.CategoriesService;

@Controller
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

		try {
			listCategories = categoriesService.getAllCategories();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("listCategories", listCategories);

		return "categories";
	}

	/**
	 * Controller thêm mới một chuyên mục
	 * 
	 * @param categories
	 * @return
	 */
	@RequestMapping(value = "/AddCategories", method = RequestMethod.POST)
	public String createCategory(Categories categories) {

		try {
			categoriesService.addCategories(categories);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect: categories";
	}

	/**
	 * Controller cập nhật một chuyên mục
	 * 
	 * @return
	 */
	@RequestMapping(value = "/EditCategories", method = RequestMethod.POST)
	public String updateCategories(Categories categories) {

		try {
			categoriesService.updateCategories(categories);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "redirect: categories";
	}

	/**
	 * Phương thức xóa bỏ 1 chuyên mục
	 * 
	 * @param categories
	 * @return
	 */
	@RequestMapping(value = "/DeleteCategories", method = RequestMethod.POST)
	public String deleteCategories(HttpServletRequest request) {
		int categoriesId;
		categoriesId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id").toString()) : 0;
		try {
			categoriesService.deleteCategories(categoriesId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "redirect: categories";
	}
}

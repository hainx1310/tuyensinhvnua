package vn.edu.vnua.dse.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.vnua.dse.entity.Categories;
import vn.edu.vnua.dse.service.CategoriesService;

@RestController
@RequestMapping("/api")
public class CategoriesApi {
	@Autowired
	private CategoriesService categoriesService;

	/**
	 * Api lấy ra danh sách categories duoc kich hoat
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/categories" }, method = RequestMethod.GET)
	public ResponseEntity<List<Categories>> listAllCategories() {
		List<Categories> listAllCategories = new ArrayList<Categories>();
		listAllCategories = categoriesService.getAllCategoriesIsActive();
		return new ResponseEntity<List<Categories>>(listAllCategories, HttpStatus.OK);
	}
}

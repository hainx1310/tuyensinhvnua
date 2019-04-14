package vn.edu.vnua.dse.service;

import java.util.List;

import vn.edu.vnua.dse.entity.Categories;

public interface CategoriesService {
	/**
	 * lay tat ca chuyen muc
	 */
	public List<Categories> getAllCategories();

	/**
	 * Services them mot categories vao db
	 */
	public void addCategories(Categories categories);

	/**
	 * Services cap nhat mot categories vao db
	 */
	public void updateCategories(Categories categories);
}

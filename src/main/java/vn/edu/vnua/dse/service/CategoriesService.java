package vn.edu.vnua.dse.service;

import java.util.List;

import vn.edu.vnua.dse.entity.Categories;

public interface CategoriesService {
	/**
	 * lay tat ca chuyen muc
	 */
	public List<Categories> getAllCategories(int startIndex);

	/**
	 * Services them mot categories vao db
	 */
	public void addCategories(Categories categories);

	/**
	 * Services cap nhat mot categories vao db
	 */
	public void updateCategories(Categories categories);

	/**
	 * Services xóa 1 categories trong db
	 */
	public void deleteCategories(int categoriesId);

	/**
	 * Services thay doi trang thai cua 1 categories trong db
	 */
	public void changeStatusCategories(int categoriesId, boolean status, String updateByUser);

	/**
	 * lay tat ca chuyen muc duoc kich hoat
	 */
	public List<Categories> getAllCategoriesIsActive();
	
	/**
	 * Phuong thuc lay tat ca chuyen muc theo id
	 * 
	 * @return
	 */
	public Categories getCategoriresById(int id);
}

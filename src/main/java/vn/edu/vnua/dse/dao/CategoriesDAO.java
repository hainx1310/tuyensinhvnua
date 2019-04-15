package vn.edu.vnua.dse.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import vn.edu.vnua.dse.entity.Categories;

public interface CategoriesDAO {

	public void setSessionFactory(SessionFactory sessionFactory);

	/**
	 * Phuong thuc lay tat ca chuyen muc duoc kich hoat
	 * 
	 * @return
	 */
	public List<Categories> getAllCategorires(int startIndex);

	/**
	 * Phuong thuc them moi chuyen muc
	 * 
	 * @param name
	 */
	public void addCategories(Categories categories);

	/**
	 * Phuong thuc cap nhat mot chuyen muc
	 * 
	 * @param name
	 */
	public void updateCategories(Categories categories);

	/**
	 * Phuong thuc xoa 1 chuyen muc
	 * 
	 * @param categoriesId
	 */
	public void deleteCategories(int categoriesId);

	/**
	 * Phuong thuc thay doi trang thai cua 1 categories
	 * 
	 * @param categoriesId
	 */
	public void changeStatusCategories(int categoriesId, boolean status);
}

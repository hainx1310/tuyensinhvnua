package vn.edu.vnua.dse.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import vn.edu.vnua.dse.entity.User;

public interface UserDAO {

	public void setSessionFactory(SessionFactory sessionFactory);

	/**
	 * Lấy tất cả user
	 */
	public List<User> getListUser();

	/**
	 * Phuong thuc them moi nguoi dung
	 * 
	 * @param name
	 */
	public void createUser(User user);

	/**
	 * Phuong thuc kiem tra username co ton tai k
	 * 
	 * @param username
	 * @return
	 */
	public boolean checkExistUserByName(String username);

	/**
	 * Phuong thuc tim kiem user theo username
	 * 
	 * @param username
	 * @return
	 */
	public List<User> getUserByUsername(String username);

	/**
	 * Phuong thuc cap nhat mot user
	 * 
	 * @param name
	 */
	public void updateUser(User user);

	/**
	 * Phuong thuc xoa 1 user
	 * 
	 * @param UserId
	 */
	public void deleteUser(int userId);

	/**
	 * Phuong thuc thay doi trang thai cua 1 User
	 * 
	 * @param UserId
	 */
	public void changeStatusUser(int userId, boolean status, String updateByUser);

	/**
	 * Lấy danh sach 10 user de phan trang
	 */
	public List<User> getListUserLimit(int startIndex);

	/**
	 * Lay so luong bai viet theo author
	 * 
	 * @param author
	 * @return
	 */
	public int getTotalPostByUser(String author);

	/**
	 * Lay so luong Video theo author
	 * 
	 * @param author
	 * @return
	 */
	public int getTotalVideoByUser(String author);
}

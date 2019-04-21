package vn.edu.vnua.dse.service;

import java.util.List;

import vn.edu.vnua.dse.entity.User;

public interface UserService {
	/**
	 * lay tat ca user
	 */
	public List<User> getListUser();

	/**
	 * Phuong thuc tao moi 1 user
	 * 
	 * @param user
	 */
	public void createUser(User user);

	/**
	 * Kiem tra user name da ton tai
	 * 
	 * @param username
	 * @return
	 */
	public boolean checkExistUserByName(String username);

	/**
	 * Phuong thuc kiem tra dang nhap
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
}

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
}

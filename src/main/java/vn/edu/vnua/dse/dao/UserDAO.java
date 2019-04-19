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
}

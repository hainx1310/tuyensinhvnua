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
}

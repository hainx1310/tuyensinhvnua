package vn.edu.vnua.dse.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import vn.edu.vnua.dse.dao.UserDAO;
import vn.edu.vnua.dse.entity.User;
import vn.edu.vnua.dse.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = Logger.getLogger(CategoriesServiceImpl.class);

	@Autowired
	private UserDAO userDao;

	@Override
	public List<User> getListUser() {
		List<User> listUser = new ArrayList<User>();
		try {
			logger.debug("GET ALL User Start");
			listUser = userDao.getListUser();
			logger.debug("GET ALL User End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listUser;
	}

	/*
	 * (non-Javadoc) Phuong thuc tao moi 1 user
	 * 
	 * @see
	 * vn.edu.vnua.dse.service.UserService#createUser(vn.edu.vnua.dse.entity.User)
	 */
	@Override
	public void createUser(User user) {
		try {
			logger.debug("Add User Start");
			userDao.createUser(user);
			logger.debug("Add User End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc kiem tra xem username da ton tai ko
	 * 
	 * @see
	 * vn.edu.vnua.dse.service.UserService#checkExistUserByName(java.lang.String)
	 */
	@Override
	public boolean checkExistUserByName(String username) {
		boolean result;
		try {
			logger.debug("Check User exist Start");
			result = userDao.checkExistUserByName(username);
			logger.debug("User exist End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result = false;
		}
		return result;
	}

	/*
	 * (non-Javadoc) Phuong thuc tra ve thong tin user theo username
	 * 
	 * @see vn.edu.vnua.dse.service.UserService#getUserByUsername(java.lang.String)
	 */
	@Override
	public List<User> getUserByUsername(String username) {
		List<User> listUser = new ArrayList<User>();
		try {
			logger.debug("GET User by username Start");
			listUser = userDao.getUserByUsername(username);
			logger.debug("GET User by username End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listUser;
	}

	/*
	 * (non-Javadoc) Cap nhat user
	 * 
	 * @see
	 * vn.edu.vnua.dse.service.UserService#updateUser(vn.edu.vnua.dse.entity.User)
	 */
	@Override
	public void updateUser(User user) {
		try {
			logger.debug("Update user Start");
			userDao.updateUser(user);
			logger.debug("Update user End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Xoa user theo userID
	 * 
	 * @see vn.edu.vnua.dse.service.UserService#deleteUser(int)
	 */
	@Override
	public void deleteUser(int userId) {
		try {
			logger.debug("Delete user Start");
			userDao.deleteUser(userId);
			logger.debug("Delete user End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Thay doi trang tahi cua user theo userId
	 * 
	 * @see vn.edu.vnua.dse.service.UserService#changeStatusUser(int, boolean,
	 * java.lang.String)
	 */
	@Override
	public void changeStatusUser(int userId, boolean status, String updateByUser) {
		try {
			logger.debug("Update user Start");
			userDao.changeStatusUser(userId, status, updateByUser);
			logger.debug("Update user End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Lay danh sach 10 user phan trang
	 * 
	 * @see vn.edu.vnua.dse.service.UserService#getListUserLimit(int)
	 */
	@Override
	public List<User> getListUserLimit(int startIndex) {
		List<User> listUser = new ArrayList<User>();
		try {
			logger.debug("GET Limit User Start");
			listUser = userDao.getListUserLimit(startIndex);
			logger.debug("GET Limit User End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listUser;
	}

}

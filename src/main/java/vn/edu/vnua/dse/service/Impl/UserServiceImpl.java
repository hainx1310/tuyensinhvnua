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
		return userDao.getListUser();
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

}

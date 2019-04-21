package vn.edu.vnua.dse.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.vnua.dse.common.CommonConst;
import vn.edu.vnua.dse.common.CommonUtils;
import vn.edu.vnua.dse.dao.UserDAO;
import vn.edu.vnua.dse.entity.User;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDAO {

	private static final Logger logger = Logger.getLogger(CategoriesDaoImpl.class.getName());

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc) Phuong thuc lay tat ca user
	 * 
	 * @see vn.edu.vnua.dse.dao.UserDAO#getListUser()
	 */
	@Override
	public List<User> getListUser() {
		List<User> listAllUser = new ArrayList<User>();

		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_lIST_USER);
			Query query = session.createSQLQuery(sql).addEntity(User.class);
			listAllUser = query.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return listAllUser;
	}

	/*
	 * (non-Javadoc) Phuong thuc them moi nguoi dung
	 * 
	 * @see vn.edu.vnua.dse.dao.UserDAO#addCategories(vn.edu.vnua.dse.entity.User)
	 */
	@Override
	public void createUser(User user) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.CREATE_USER);
			Query query = session.createSQLQuery(sql);
			query.setParameter("email", user.getEmail());
			query.setParameter("username", user.getUsername());
			query.setParameter("password", user.getPassword());
			query.setParameter("passwordSalt", user.getPasswordSalt());
			query.setParameter("role", user.isRole());
			query.setParameter("createdUser", user.getCreatedUser());
			query.setParameter("status", user.isStatus());
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Kiem tra username co ton tai khong
	 * 
	 * @see vn.edu.vnua.dse.dao.UserDAO#checkExistUserByName(java.lang.String)
	 */
	@Override
	public boolean checkExistUserByName(String username) {
		List<User> list = (ArrayList<User>) getListUser();
		if (username != null && list.size() > 0) {
			for (User user : list) {
				if (user.getUsername().equalsIgnoreCase(username))
					return true; // ton tai
			}
		}
		return false; // ko ton tai
	}

	/*
	 * (non-Javadoc) Phuong thuc tim kiem user theo username
	 * 
	 * @see vn.edu.vnua.dse.dao.UserDAO#getUserByUsername(java.lang.String)
	 */
	@Override
	public List<User> getUserByUsername(String username) {
		List<User> listUser = new ArrayList<User>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_USER_BY_USERNAME);
			Query query = session.createSQLQuery(sql).addEntity(User.class);
			query.setParameter("username", username);
			listUser = (List<User>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listUser;
	}

	/*
	 * (non-Javadoc) Phuong thuc cap nhat mot user
	 * 
	 * @see vn.edu.vnua.dse.dao.UserDAO#updateUser(vn.edu.vnua.dse.entity.User)
	 */
	@Override
	public void updateUser(User user) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.UPDATE_USER);
			Query query = session.createSQLQuery(sql);
			query.setParameter("updated_user", user.getUpdatedUser());
			query.setParameter("status", user.isStatus());
			query.setParameter("role", user.isRole());
			query.setParameter("id", user.getId());
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc xoa 1 user
	 * 
	 * @see vn.edu.vnua.dse.dao.UserDAO#deleteUser(int)
	 */
	@Override
	public void deleteUser(int userId) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.DELETE_USER);
			Query query = session.createSQLQuery(sql);
			query.setParameter("id", userId);
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc thay doi trang thai cua 1 User
	 * 
	 * @see vn.edu.vnua.dse.dao.UserDAO#changeStatusUser(int, boolean,
	 * java.lang.String)
	 */
	@Override
	public void changeStatusUser(int userId, boolean status, String updateByUser) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.CHANGE_STATUS_USER);
			Query query = session.createSQLQuery(sql);
			query.setParameter("updated_user", updateByUser);
			query.setParameter("status", status);
			query.setParameter("id", userId);
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Lấy danh sach 10 user de phan trang
	 * 
	 * @see vn.edu.vnua.dse.dao.UserDAO#getListUserLimit(int)
	 */
	@Override
	public List<User> getListUserLimit(int startIndex) {
		List<User> listUserLimit = new ArrayList<User>();

		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM User");
			query.setFirstResult(startIndex);
			query.setMaxResults(10);

			listUserLimit = (List<User>) query.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return listUserLimit;
	}

}

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

}

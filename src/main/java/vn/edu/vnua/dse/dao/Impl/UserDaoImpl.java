package vn.edu.vnua.dse.dao.Impl;

import java.util.ArrayList;
import java.util.List;

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
public class UserDaoImpl implements UserDAO {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
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

}

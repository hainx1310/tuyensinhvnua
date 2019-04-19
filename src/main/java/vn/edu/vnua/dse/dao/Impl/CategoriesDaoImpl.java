package vn.edu.vnua.dse.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
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
import vn.edu.vnua.dse.dao.CategoriesDAO;
import vn.edu.vnua.dse.entity.Categories;

@Repository
@Transactional
public class CategoriesDaoImpl implements CategoriesDAO {

	private static final Logger logger = Logger.getLogger(CategoriesDaoImpl.class.getName());

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc) Lay ra danh sach tat ca chuyen muc dang kich hoat
	 * 
	 * @see vn.edu.vnua.dse.dao.CategoriesDAO#getAllCategorires()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Categories> getAllCategorires(int startIndex) {
		List<Categories> listCategories = new ArrayList<Categories>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_lIST_CATEGORIES);
			Query query;
			if (startIndex < 0) {
				query = session.createSQLQuery(sql).addEntity(Categories.class);
			} else {
				query = session.createQuery("FROM Categories");
				query.setFirstResult(startIndex);
				query.setMaxResults(10);
			}
			listCategories = (List<Categories>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listCategories;
	}

	/*
	 * (non-Javadoc) Them mot chuyen muc vao bang categories
	 * 
	 * @see vn.edu.vnua.dse.dao.CategoriesDAO#addCategories(vn.edu.vnua.dse.entity.
	 * Categories)
	 */
	@Override
	public void addCategories(Categories categories) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.INSERT_CATEGORIES);
			Query query = session.createSQLQuery(sql);
			query.setParameter("name", categories.getName());
			query.setParameter("created_date", new Date());
			query.setParameter("created_user", categories.getCreatedUser());
			query.setParameter("updated_date", categories.getUpdatedDate());
			query.setParameter("updated_user", categories.getUpdatedUser());
			query.setParameter("status", categories.isStatus());

			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * Cap nhat mot chuyen muc (non-Javadoc)
	 * 
	 * @see
	 * vn.edu.vnua.dse.dao.CategoriesDAO#updateCategories(vn.edu.vnua.dse.entity.
	 * Categories)
	 */
	@Override
	public void updateCategories(Categories categories) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.UPDATE_CATEGORIES);
			Query query = session.createSQLQuery(sql);
			query.setParameter("name", categories.getName());
			query.setParameter("updated_user", categories.getUpdatedUser());
			query.setParameter("status", categories.isStatus());
			query.setParameter("id", categories.getId());
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc xoa 1 chuyen muc
	 * 
	 * @see vn.edu.vnua.dse.dao.CategoriesDAO#deleteCategories(int)
	 */
	@Override
	public void deleteCategories(int categoriesId) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.DELETE_CATEGORIES);
			Query query = session.createSQLQuery(sql);
			query.setParameter("id", categoriesId);
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void changeStatusCategories(int categoriesId, boolean status) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.CHANGE_STATUS_CATEGORIES);
			Query query = session.createSQLQuery(sql);
			query.setParameter("updated_user", "hainx");
			query.setParameter("status", status);
			query.setParameter("id", categoriesId);
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc lay tat ca chuyen muc dang duoc kich hoat
	 * 
	 * @see vn.edu.vnua.dse.dao.CategoriesDAO#getListCategoriesIsActive()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Categories> getListCategoriesIsActive() {
		List<Categories> listCategories = new ArrayList<Categories>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_lIST_CATEGORIES_IS_ACTIVE);
			Query query = session.createSQLQuery(sql).addEntity(Categories.class);
			listCategories = (List<Categories>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listCategories;
	}

}

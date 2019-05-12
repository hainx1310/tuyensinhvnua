package vn.edu.vnua.dse.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.edu.vnua.dse.common.CommonConst;
import vn.edu.vnua.dse.common.CommonUtils;
import vn.edu.vnua.dse.dao.CommentDAO;
import vn.edu.vnua.dse.entity.Comment;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class CommentDaoImpl implements CommentDAO {

	private static final Logger logger = Logger.getLogger(CommentDaoImpl.class);

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc) Lay danh sach comment cua bai viet
	 * 
	 * @see vn.edu.vnua.dse.dao.CommentDAO#getComments(int)
	 */
	@Override
	public List<Comment> getComments(int postId) {
		List<Comment> listResult = new ArrayList<Comment>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_COMMENT_BY_POST_ID);
			Query query = session.createSQLQuery(sql).addEntity(Comment.class);
			query.setParameter("postId", postId);
			listResult = (List<Comment>) query.list();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) API them binh luan ve bai viet
	 * 
	 * @see
	 * vn.edu.vnua.dse.dao.CommentDAO#createComment(vn.edu.vnua.dse.entity.Comment)
	 */
	@Override
	public void createComment(Comment comment) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.CREATE_COMMENT);
			Query query = session.createSQLQuery(sql);
			query.setParameter("postId", comment.getpost().getId());
			query.setParameter("name", comment.getName());
			query.setParameter("comment", comment.getComment());
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Lay tat ca danh sach binh luan da dc duyet
	 * 
	 * @see vn.edu.vnua.dse.dao.CommentDAO#getAllCommentAprroved()
	 */
	@Override
	public List<Comment> getAllCommentAprroved() {
		List<Comment> listResult = new ArrayList<Comment>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_ALL_COMMENT_APPROVED);
			Query query = session.createSQLQuery(sql).addEntity(Comment.class);
			listResult = (List<Comment>) query.list();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay tat ca danh sach binh luan dang cho duyet
	 * 
	 * @see vn.edu.vnua.dse.dao.CommentDAO#getAllCommentPending()
	 */
	@Override
	public List<Comment> getAllCommentPending() {
		List<Comment> listResult = new ArrayList<Comment>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_ALL_COMMENT_PENDING);
			Query query = session.createSQLQuery(sql).addEntity(Comment.class);
			listResult = (List<Comment>) query.list();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay 10 binh luan da dc duyet
	 * 
	 * @see vn.edu.vnua.dse.dao.CommentDAO#getLimitCommentAprroved(int)
	 */
	@Override
	public List<Comment> getLimitCommentAprroved(int startIndex) {
		List<Comment> listResult = new ArrayList<Comment>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Comment WHERE status = 1");
			query.setFirstResult(startIndex);
			query.setMaxResults(10);
			listResult = (List<Comment>) query.list();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay 10 binh luan dang cho duyet
	 * 
	 * @see vn.edu.vnua.dse.dao.CommentDAO#getLimitCommentPending(int)
	 */
	@Override
	public List<Comment> getLimitCommentPending(int startIndex) {
		List<Comment> listResult = new ArrayList<Comment>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Comment WHERE status = 0");
			query.setFirstResult(startIndex);
			query.setMaxResults(10);
			listResult = (List<Comment>) query.list();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Phuong thuc duyet comment
	 * 
	 * @see vn.edu.vnua.dse.dao.CommentDAO#approved(int, java.lang.String)
	 */
	@Override
	public void approved(int commentId, String approvedUser) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.APPROVED_COMMENT);
			Query query = session.createSQLQuery(sql);
			query.setParameter("approvedUser", approvedUser);
			query.setParameter("id", commentId);
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc go comment
	 * 
	 * @see vn.edu.vnua.dse.dao.CommentDAO#unapproved(int, java.lang.String)
	 */
	@Override
	public void unapproved(int commentId, String unapprovedUser) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.UNAPPROVED_COMMENT);
			Query query = session.createSQLQuery(sql);
			query.setParameter("unapprovedUser", unapprovedUser);
			query.setParameter("id", commentId);
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

}

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
import vn.edu.vnua.dse.service.Impl.CategoriesServiceImpl;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDAO {

	private static final Logger logger = Logger.getLogger(CategoriesServiceImpl.class);

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
	@SuppressWarnings("unchecked")
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

}

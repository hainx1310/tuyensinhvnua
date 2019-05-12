package vn.edu.vnua.dse.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import vn.edu.vnua.dse.dao.CommentDAO;
import vn.edu.vnua.dse.entity.Comment;
import vn.edu.vnua.dse.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	private static final Logger logger = Logger.getLogger(CommentServiceImpl.class);

	@Autowired
	private CommentDAO commentDao;

	/*
	 * (non-Javadoc) Lay danh sach comment cua bai viet
	 * 
	 * @see vn.edu.vnua.dse.service.CommentService#getComments(int)
	 */
	@Override
	public List<Comment> getComments(int postId) {
		List<Comment> listResult = new ArrayList<Comment>();
		try {
			logger.debug("Service getComments Start");
			listResult = commentDao.getComments(postId);
			logger.debug("Service getComments End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) API them binh luan ve bai viet
	 * 
	 * @see
	 * vn.edu.vnua.dse.service.CommentService#createComment(vn.edu.vnua.dse.entity.
	 * Comment)
	 */
	@Override
	public void createComment(Comment comment) {
		try {
			logger.debug("Add Comment Start");
			commentDao.createComment(comment);
			logger.debug("Add Comment End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	@Override
	public List<Comment> getAllCommentAprroved() {
		List<Comment> listResult = new ArrayList<Comment>();
		try {
			logger.debug("Service getAllCommentAprroved Start");
			listResult = commentDao.getAllCommentAprroved();
			logger.debug("Service getAllCommentAprroved End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	@Override
	public List<Comment> getAllCommentPending() {
		List<Comment> listResult = new ArrayList<Comment>();
		try {
			logger.debug("Service getAllCommentPending Start");
			listResult = commentDao.getAllCommentPending();
			logger.debug("Service getAllCommentPending End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	@Override
	public List<Comment> getLimitCommentAprroved(int startIndex) {
		List<Comment> listResult = new ArrayList<Comment>();
		try {
			logger.debug("Service getLimitCommentAprroved Start");
			listResult = commentDao.getLimitCommentAprroved(startIndex);
			logger.debug("Service getLimitCommentAprroved End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	@Override
	public List<Comment> getLimitCommentPending(int startIndex) {
		List<Comment> listResult = new ArrayList<Comment>();
		try {
			logger.debug("Service getLimitCommentPending Start");
			listResult = commentDao.getLimitCommentPending(startIndex);
			logger.debug("Service getLimitCommentPending End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Phuong thuc duyet comment
	 * 
	 * @see vn.edu.vnua.dse.service.CommentService#approved(int, java.lang.String)
	 */
	@Override
	public void approved(int commentId, String approvedUser) {
		try {
			logger.debug("approved Comment Start");
			commentDao.approved(commentId, approvedUser);
			logger.debug("approved Comment End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc go comment
	 * 
	 * @see vn.edu.vnua.dse.service.CommentService#unapproved(int, java.lang.String)
	 */
	@Override
	public void unapproved(int commentId, String unapprovedUser) {
		try {
			logger.debug("unapproved Comment Start");
			commentDao.approved(commentId, unapprovedUser);
			logger.debug("unapproved Comment End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

}

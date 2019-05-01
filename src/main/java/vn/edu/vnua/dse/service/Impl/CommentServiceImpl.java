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

	private static final Logger logger = Logger.getLogger(CategoriesServiceImpl.class);

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

}

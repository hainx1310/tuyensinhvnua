package vn.edu.vnua.dse.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import vn.edu.vnua.dse.entity.Comment;

public interface CommentDAO {

	public void setSessionFactory(SessionFactory sessionFactory);

	/**
	 * Lay danh sach comment cua bai viet
	 * 
	 * @param postId
	 * @return
	 */
	public List<Comment> getComments(int postId);

	/**
	 * API them binh luan ve bai viet
	 * 
	 * @param comment
	 */
	public void createComment(Comment comment);
}

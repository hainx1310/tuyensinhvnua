package vn.edu.vnua.dse.service;

import java.util.List;

import vn.edu.vnua.dse.entity.Comment;

public interface CommentService {

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

	/**
	 * Lay tat ca danh sach binh luan da dc duyet
	 * 
	 * @return
	 */
	public List<Comment> getAllCommentAprroved();
	
	/**
	 * Lay tat ca danh sach binh luan khong dc duyet
	 * 
	 * @return
	 */
	public List<Comment> getAllCommentNotAprroved();

	/**
	 * Lay tat ca danh sach binh luan dang cho duyet
	 * 
	 * @return
	 */
	public List<Comment> getAllCommentPending();

	/**
	 * Lay 5 binh luan da dc duyet
	 * 
	 * @return
	 */
	public List<Comment> getLimitCommentAprroved(int startIndex);
	
	/**
	 * Lay 5 binh luan khong dc duyet
	 * 
	 * @return
	 */
	public List<Comment> getLimitCommentNotAprroved(int startIndex);

	/**
	 * Lay 5 binh luan dang cho duyet
	 * 
	 * @return
	 */
	public List<Comment> getLimitCommentPending(int startIndex);

	/**
	 * Phuong thuc duyet comment
	 * 
	 * @param commentId
	 */
	public void approved(int commentId, String approvedUser);

	/**
	 * Phuong thuc go comment
	 * 
	 * @param commentId
	 */
	public void unapproved(int commentId, String unapprovedUser);
}

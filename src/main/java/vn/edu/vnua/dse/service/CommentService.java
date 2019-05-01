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
}

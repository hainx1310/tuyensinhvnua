package vn.edu.vnua.dse.service;

import java.util.List;

import vn.edu.vnua.dse.entity.Post;

public interface PostService {
	/**
	 * Tao moi bai viet
	 * 
	 * @param post
	 */
	public void createdPost(Post post);

	/**
	 * Sua bai viet
	 * 
	 * @param post
	 */
	public void updatePost(Post post);

	/**
	 * Xoa bai viet
	 * 
	 * @param id
	 */
	public void deletePost(int id);

	/**
	 * Lay danh sach tat ca bai viet
	 * 
	 * @return
	 */
	public List<Post> getAllPost();

	/**
	 * Lay danh sach 10 bai viet
	 * 
	 * @return
	 */
	public List<Post> getLimitedPost(int startIndex);

	/**
	 * Lay danh sach bai viet da xuat ban
	 * 
	 * @return
	 */
	public List<Post> getPostPublished();

	/**
	 * Lay danh sach 10 bai viet da xuat ban
	 * 
	 * @return
	 */
	public List<Post> getLimitPostPublished(int startIndex);

	/**
	 * Lay danh sach bai viet dang cho duyet
	 * 
	 * @return
	 */
	public List<Post> getPendingPost();

	/**
	 * Lay danh sach 10 bai viet dang cho duyet
	 * 
	 * @return
	 */
	public List<Post> getLimitPendingPost(int startIndex);

	/**
	 * Lay danh sach bai viet da duyet
	 * 
	 * @return
	 */
	public List<Post> getApprovedPost();

	/**
	 * Lay danh sach 10 bai viet da duyet
	 * 
	 * @return
	 */
	public List<Post> getLimitApprovedPost(int startIndex);

	/**
	 * Lay danh sach bai viet da xuat ban theo chuyen muc
	 * 
	 * @return
	 */
	public List<Post> getPostPublishedByCategoriesId(int categoriesId);

	/**
	 * Lay danh sach 10 bai viet da xuat ban theo chuyen muc
	 * 
	 * @param categoriesId
	 * @return
	 */
	public List<Post> getPostPublishedByCategoriesIdLimit(int categoriesId, int startIndex);
	
	/**
	 * Phuong thuc duyet bai viet
	 * 
	 * @param postId
	 */
	public void approved(int postId, String approvedUser);
	
	/**
	 * Phuong thuc go bai viet
	 * 
	 * @param postId
	 */
	public void unapproved(int postId, String unapprovedUser);
}

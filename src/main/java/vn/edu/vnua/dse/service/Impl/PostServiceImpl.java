package vn.edu.vnua.dse.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import vn.edu.vnua.dse.dao.PostDAO;
import vn.edu.vnua.dse.entity.Post;
import vn.edu.vnua.dse.service.PostService;

@Service("postService")
public class PostServiceImpl implements PostService {

	private static final Logger logger = Logger.getLogger(PostServiceImpl.class);

	@Autowired
	private PostDAO postDao;

	/*
	 * (non-Javadoc) Tao moi bai viet
	 * 
	 * @see
	 * vn.edu.vnua.dse.service.PostService#createdPost(vn.edu.vnua.dse.entity.Post)
	 */
	@Override
	public void createdPost(Post post) {
		try {
			logger.debug("Add Post Start");
			postDao.createdPost(post);
			logger.debug("Add Post End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Sua bai viet
	 * 
	 * @see
	 * vn.edu.vnua.dse.service.PostService#updatePost(vn.edu.vnua.dse.entity.Post)
	 */
	@Override
	public void updatePost(Post post) {
		try {
			logger.debug("Update Post Start");
			postDao.updatePost(post);
			logger.debug("Update Post End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Xoa bai viet
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#deletePost(int)
	 */
	@Override
	public void deletePost(int id) {
		try {
			logger.debug("Delete POST Start");
			postDao.deletePost(id);
			logger.debug("Delete POST End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Lay danh sach tat ca bai viet
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getAllPost()
	 */
	@Override
	public List<Post> getAllPost() {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET ALL Post Start");
			listResult = postDao.getAllPost();
			logger.debug("GET ALL Post End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach 10 bai viet theo tat ca chuyen muc
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getLimitedPost(int)
	 */
	@Override
	public List<Post> getLimitedPost(int startIndex) {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET ALL Post Start");
			listResult = postDao.getLimitedPost(startIndex);
			logger.debug("GET ALL Post End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach bai viet da xuat ban
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getPostPublished()
	 */
	@Override
	public List<Post> getPostPublished() {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getPostPublished Post Start");
			listResult = postDao.getPostPublished();
			logger.debug("GET ALL getPostPublished End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach bai viet dang cho duyet
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getPendingPost()
	 */
	@Override
	public List<Post> getPendingPost() {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getPendingPost Post Start");
			listResult = postDao.getPendingPost();
			logger.debug("GET ALL getPendingPost End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach bai viet da duyet
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getApprovedPost()
	 */
	@Override
	public List<Post> getApprovedPost() {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getApprovedPost Post Start");
			listResult = postDao.getApprovedPost();
			logger.debug("GET ALL getApprovedPost End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach bai viet da xuat ban theo chuyen muc
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getPostPublishedByCategoriesId(int)
	 */
	@Override
	public List<Post> getPostPublishedByCategoriesId(int categoriesId) {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getPostPublishedByCategoriesId Post Start");
			listResult = postDao.getPostPublishedByCategoriesId(categoriesId);
			logger.debug("GET ALL getPostPublishedByCategoriesId End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach 10 bai viet da xuat ban theo chuyen muc
	 * 
	 * @see
	 * vn.edu.vnua.dse.service.PostService#getPostPublishedByCategoriesIdLimit(int,
	 * int)
	 */
	@Override
	public List<Post> getPostPublishedByCategoriesIdLimit(int categoriesId, int startIndex) {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getPostPublishedByCategoriesIdLimit Post Start");
			listResult = postDao.getPostPublishedByCategoriesIdLimit(categoriesId, startIndex);
			logger.debug("GET ALL getPostPublishedByCategoriesIdLimit End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach 10 bai viet da xuat ban
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getLimitPostPublished(int)
	 */
	@Override
	public List<Post> getLimitPostPublished(int startIndex, int limit) {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getLimitPostPublished Post Start");
			listResult = postDao.getLimitPostPublished(startIndex, limit);
			logger.debug("GET ALL getLimitPostPublished End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach 10 bai viet dang cho duyet
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getLimitPendingPost(int)
	 */
	@Override
	public List<Post> getLimitPendingPost(int startIndex) {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getLimitPendingPost Post Start");
			listResult = postDao.getLimitPendingPost(startIndex);
			logger.debug("GET ALL getLimitPendingPost End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach 10 bai viet da duyet
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getLimitApprovedPost(int)
	 */
	@Override
	public List<Post> getLimitApprovedPost(int startIndex) {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getLimitApprovedPost Post Start");
			listResult = postDao.getLimitApprovedPost(startIndex);
			logger.debug("GET ALL getLimitApprovedPost End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Phuong thuc duyet bai viet
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#approved(int, java.lang.String)
	 */
	@Override
	public void approved(int postId, String approvedUser, Date publishedDate) {
		try {
			logger.debug("approved Post Start");
			postDao.approved(postId, approvedUser, publishedDate);
			logger.debug("approved Post End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc go bai viet
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#unapproved(int, java.lang.String)
	 */
	@Override
	public void unapproved(int postId, String unapprovedUser) {
		try {
			logger.debug("unapproved Post Start");
			postDao.unapproved(postId, unapprovedUser);
			logger.debug("unapproved Post End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc lay bai viet theo id
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getPostById(int)
	 */
	@Override
	public Post getPostById(int id) {
		Post post = new Post();
		try {
			logger.debug("GET getPostById Start");
			post = postDao.getPostById(id);
			logger.debug("GET getPostById End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return post;
	}

	/*
	 * (non-Javadoc) Lay danh sach bai viet da duyet theo id.
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getListPostById(java.lang.String)
	 */
	@Override
	public List<Post> getListPostById(String arrayPostId) {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getListPostById Start");
			listResult = postDao.getListPostById(arrayPostId);
			logger.debug("GET ALL getListPostById End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach bai theo keyword
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getPostByKeyword(java.lang.String,
	 * int)
	 */
	@Override
	public List<Post> getPostByKeyword(String keyword, int startIndex) {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getPostByKeyword Post Start");
			listResult = postDao.getPostByKeyword(keyword, startIndex);
			logger.debug("GET ALL getPostByKeyword End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach tat ca bai viet da bi bi go
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getPostUnPublic()
	 */
	@Override
	public List<Post> getPostUnPublic() {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getPostUnPublic Start");
			listResult = postDao.getPostUnPublic();
			logger.debug("GET getPostUnPublic End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach 10 bai viet bị gỡ Lay danh sach 10 bai viet bị gỡ
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getLimitPostUnPublic(int)
	 */
	@Override
	public List<Post> getLimitPostUnPublic(int startIndex) {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getLimitPostUnPublic Start");
			listResult = postDao.getLimitPostUnPublic(startIndex);
			logger.debug("GET getLimitPostUnPublic End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Phuong thuc bo go bai viet
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#publicPost(int)
	 */
	@Override
	public void publicPost(int postId) {
		try {
			logger.debug("publicPost Start");
			postDao.publicPost(postId);
			logger.debug("publicPost End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Lay so luong bai viet đã đăng theo user
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getPostIsPublishedByUserId(int)
	 */
	@Override
	public int getPostIsPublishedByUserId(int userId) {
		int result = 0;
		try {
			logger.debug("getPostIsPublishedByUserId Start");
			result = postDao.getPostIsPublishedByUserId(userId);
			logger.debug("getPostIsPublishedByUserId End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}

	/*
	 * (non-Javadoc) Lay danh sach giới hạn bai viet đã đăng theo user
	 * 
	 * @see vn.edu.vnua.dse.service.PostService#getLimitPostIsPublishedByUserId(int,
	 * int, int)
	 */
	@Override
	public List<Post> getLimitPostIsPublishedByUserId(int startIndex, int limit, int userId) {
		List<Post> listResult = new ArrayList<Post>();
		try {
			logger.debug("GET getLimitPostIsPublishedByUserId Start");
			listResult = postDao.getLimitPostIsPublishedByUserId(startIndex, limit, userId);
			logger.debug("GET getLimitPostIsPublishedByUserId End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

}

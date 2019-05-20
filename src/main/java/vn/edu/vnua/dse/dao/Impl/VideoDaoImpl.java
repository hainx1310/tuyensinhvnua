package vn.edu.vnua.dse.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
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
import vn.edu.vnua.dse.dao.VideoDAO;
import vn.edu.vnua.dse.entity.Video;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class VideoDaoImpl implements VideoDAO {

	private static final Logger logger = Logger.getLogger(VideoDaoImpl.class.getName());

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc) Phuong thuc lay tat ca video
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getAllVideo()
	 */
	@Override
	public List<Video> getAllVideo() {
		List<Video> listVideo = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_ALL_VIDEO);
			Query query;
			query = session.createSQLQuery(sql).addEntity(Video.class);
			listVideo = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listVideo;
	}

	/*
	 * (non-Javadoc) Phuong thuc lay litmited video
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getLimitedVideo(int)
	 */
	@Override
	public List<Video> getLimitedVideo(int startIndex) {
		List<Video> listLitmitdVideo = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Video WHERE public = 1");
			query.setFirstResult(startIndex);
			query.setMaxResults(10);
			listLitmitdVideo = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listLitmitdVideo;
	}

	/*
	 * (non-Javadoc) Phuong thuc them moi 1 video
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#addVideo(vn.edu.vnua.dse.entity.Video)
	 */
	@Override
	public void addVideo(Video video) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.CREATE_VIDEO);
			Query query = session.createSQLQuery(sql);
			query.setParameter("status", video.isStatus());
			query.setParameter("videoYoutubeId", video.getVideoYoutubeId());
			query.setParameter("title", video.getTitle());
			query.setParameter("shortContent", video.getShortContent());
			query.setParameter("editor", video.getEditor());
			query.setParameter("author", video.getAuthor());
			query.setParameter("publishedDate", video.getPublishedDate());
			query.setParameter("avatarVideo", video.getAvatarVideo());
			query.setParameter("userId", video.getUser().getId());
			
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc cap nhat 1 Video
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#updateVideo(vn.edu.vnua.dse.entity.Video)
	 */
	@Override
	public void updateVideo(Video video) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.UPDATE_VIDEO);
			Query query = session.createSQLQuery(sql);
			query.setParameter("videoYoutubeId", video.getVideoYoutubeId());
			query.setParameter("title", video.getTitle());
			query.setParameter("shortContent", video.getShortContent());
			query.setParameter("publishedDate", video.getPublishedDate());
			query.setParameter("updatedUser", video.getUpdatedUser());
			query.setParameter("id", video.getId());
			query.setParameter("avatarVideo", video.getAvatarVideo());

			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc xoa 1 Video
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#deleteVideo(int)
	 */
	@Override
	public void deleteVideo(int videoId) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.DELETE_VIDEO);
			Query query = session.createSQLQuery(sql);
			query.setParameter("id", videoId);
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc thay doi trang thai cua 1 Video
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#changeStatusVideo(int, boolean,
	 * java.lang.String)
	 */
	@Override
	public void changeStatusVideo(int videoId, boolean status, String updateByUser) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.CHANGE_STATUS_VIDEO);
			Query query = session.createSQLQuery(sql);
			query.setParameter("updatedUser", updateByUser);
			query.setParameter("status", status);
			query.setParameter("id", videoId);
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc lay tat ca video dang duoc kich hoat
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getListVideoIsActive()
	 */
	@Override
	public List<Video> getListVideoIsActive() {
		List<Video> listResult = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_ALL_VIDEO_IS_ACTIVE);
			Query query = session.createSQLQuery(sql).addEntity(Video.class);
			listResult = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Phuong thuc lay limited video dang duoc kich hoat
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getLimitVideoIsActive(int)
	 */
	@Override
	public List<Video> getLimitVideoIsActive(int startIndex) {
		List<Video> listResult = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Video WHERE status = 1 order by publishedDate desc");
			query.setFirstResult(startIndex);
			query.setMaxResults(10);
			listResult = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach tat ca video dang cho duyet
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getPendingVideo()
	 */
	@Override
	public List<Video> getPendingVideo() {
		List<Video> listVideo = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_ALL_VIDEO_PENDING);
			Query query;
			query = session.createSQLQuery(sql).addEntity(Video.class);
			listVideo = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listVideo;
	}

	/*
	 * (non-Javadoc) Lay danh sach 10 video dang cho duyet
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getLimitPendingVideo(int)
	 */
	@Override
	public List<Video> getLimitPendingVideo(int startIndex) {
		List<Video> listResult = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Video Where status = 0");
			query.setFirstResult(startIndex);
			query.setMaxResults(10);
			listResult = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach tat ca video da duyet
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getApprovedVideo()
	 */
	@Override
	public List<Video> getApprovedVideo() {
		List<Video> listResult = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_ALL_VIDEO_APPROVED);
			Query query;
			query = session.createSQLQuery(sql).addEntity(Video.class);
			listResult = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach 10 video da duyet
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getLimitApprovedVideo(int)
	 */
	@Override
	public List<Video> getLimitApprovedVideo(int startIndex) {
		List<Video> listResult = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(
					"FROM Video WHERE status = 1 AND public = 1 AND publishedDate > NOW() ORDER BY publishedDate DESC");
			query.setFirstResult(startIndex);
			query.setMaxResults(10);
			listResult = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Lay danh sach tat ca video da dang
	 * 
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getPublishedVideo()
	 */
	@Override
	public List<Video> getPublishedVideo() {
		List<Video> listVideo = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_ALL_VIDEO_PUBLISHED);
			Query query;
			query = session.createSQLQuery(sql).addEntity(Video.class);
			listVideo = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listVideo;
	}

	/*
	 * (non-Javadoc) Lay danh sach 10 video da dang
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getLimitPublishedVideo(int)
	 */
	@Override
	public List<Video> getLimitPublishedVideo(int startIndex) {
		List<Video> listResult = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(
					"FROM Video WHERE status = 1 AND public = 1 AND publishedDate <= NOW() ORDER BY publishedDate DESC");
			query.setFirstResult(startIndex);
			query.setMaxResults(10);
			listResult = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Phuong thuc lay video theo id
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getVideoById(int)
	 */
	@Override
	public Video getVideoById(int id) {
		List<Video> listResult = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_VIDEO_BY_ID);
			Query query;
			query = session.createSQLQuery(sql).addEntity(Video.class);
			listResult = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listResult == null ? null : listResult.get(0);
	}

	/*
	 * (non-Javadoc) Phuong thuc duyet video
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#approved(int, java.lang.String)
	 */
	@Override
	public void approved(int videoId, String approvedUser, Date publishedDate) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.APPROVED_VIDEO);
			Query query = session.createSQLQuery(sql);
			query.setParameter("approvedUser", approvedUser);
			query.setParameter("publishedDate", publishedDate);
			query.setParameter("id", videoId);
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc go video
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#unapproved(int, java.lang.String)
	 */
	@Override
	public void unapproved(int videoId, String unapprovedUser) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.UNAPPROVED_VIDEO);
			Query query = session.createSQLQuery(sql);
			query.setParameter("unapprovedUser", unapprovedUser);
			query.setParameter("id", videoId);
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc bo go video
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#publicVideo(int)
	 */
	@Override
	public void publicVideo(int videoId) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.PUBLIC_VIDEO);
			Query query = session.createSQLQuery(sql);
			query.setParameter("id", videoId);
			query.executeUpdate();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	/*
	 * (non-Javadoc) Lay danh sach tat ca cac video da bị go
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getVideounPublic()
	 */
	@Override
	public List<Video> getVideounPublic() {
		List<Video> listVideo = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String sql = CommonUtils.readSqlFile(CommonConst.SqlFileName.GET_ALL_VIDEO_UNPUBLIC);
			Query query;
			query = session.createSQLQuery(sql).addEntity(Video.class);
			listVideo = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listVideo;
	}

	/*
	 * (non-Javadoc) Lay danh sach 5 video bị gỡ
	 * 
	 * @see vn.edu.vnua.dse.dao.VideoDAO#getLimitVideoUnPublic(int)
	 */
	@Override
	public List<Video> getLimitVideoUnPublic(int startIndex) {
		List<Video> listResult = new ArrayList<Video>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Video WHERE public = 0");
			query.setFirstResult(startIndex);
			query.setMaxResults(5);
			listResult = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listResult;
	}

}

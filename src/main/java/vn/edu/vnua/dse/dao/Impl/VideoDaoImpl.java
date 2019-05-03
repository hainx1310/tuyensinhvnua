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
			Query query = session.createQuery("FROM Video");
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
			query.setParameter("videoYoutubeId", video.getVideoYoutubeId());
			query.setParameter("title", video.getTitle());
			query.setParameter("shortContent", video.getShortContent());
			query.setParameter("editor", video.getEditor());
			query.setParameter("author", video.getAuthor());
			query.setParameter("publishedDate", video.getPublishedDate());
			query.setParameter("avatarVideo", video.getAvatarVideo());

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
			Query query = session.createQuery("FROM Video WHERE status = :status order by publishedDate desc");
			query.setFirstResult(startIndex);
			query.setMaxResults(10);
			listResult = (List<Video>) query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new RuntimeException(ex);
		}
		return listResult;
	}

}

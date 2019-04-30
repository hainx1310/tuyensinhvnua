package vn.edu.vnua.dse.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import vn.edu.vnua.dse.dao.VideoDAO;
import vn.edu.vnua.dse.entity.Video;
import vn.edu.vnua.dse.service.VideoService;

@Service("videoService")
public class VideoServiceImpl implements VideoService {

	private static final Logger logger = Logger.getLogger(VideoServiceImpl.class);

	@Autowired
	private VideoDAO videoDao;

	/*
	 * (non-Javadoc) Phuong thuc lay tat ca video
	 * 
	 * @see vn.edu.vnua.dse.service.VideoService#getAllVideo()
	 */
	@Override
	public List<Video> getAllVideo() {
		List<Video> listResult = new ArrayList<Video>();
		try {
			logger.debug("GET ALL Video Start");
			listResult = videoDao.getAllVideo();
			logger.debug("GET ALL Video End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Phuong thuc lay litmited video
	 * 
	 * @see vn.edu.vnua.dse.service.VideoService#getLimitedVideo(int)
	 */
	@Override
	public List<Video> getLimitedVideo(int startIndex) {
		List<Video> listResult = new ArrayList<Video>();
		try {
			logger.debug("GET getLimitedVideo Start");
			listResult = videoDao.getLimitedVideo(startIndex);
			logger.debug("GET getLimitedVideo End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Phuong thuc them moi 1 video
	 * 
	 * @see
	 * vn.edu.vnua.dse.service.VideoService#addVideo(vn.edu.vnua.dse.entity.Video)
	 */
	@Override
	public void addVideo(Video video) {
		try {
			logger.debug("addVideo Start");
			videoDao.addVideo(video);
			logger.debug("addVideo End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc cap nhat 1 Video
	 * 
	 * @see vn.edu.vnua.dse.service.VideoService#updateVideo(vn.edu.vnua.dse.entity.
	 * Video)
	 */
	@Override
	public void updateVideo(Video Video) {
		try {
			logger.debug("updateVideo Start");
			videoDao.updateVideo(Video);
			logger.debug("updateVideo End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc xoa 1 Video
	 * 
	 * @see vn.edu.vnua.dse.service.VideoService#deleteVideo(int)
	 */
	@Override
	public void deleteVideo(int videoId) {
		try {
			logger.debug("deleteVideo Start");
			videoDao.deleteVideo(videoId);
			logger.debug("deleteVideo End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc thay doi trang thai cua 1 Video
	 * 
	 * @see vn.edu.vnua.dse.service.VideoService#changeStatusVideo(int, boolean,
	 * java.lang.String)
	 */
	@Override
	public void changeStatusVideo(int videoId, boolean status, String updateByUser) {
		try {
			logger.debug("changeStatusVideo Start");
			videoDao.changeStatusVideo(videoId, status, updateByUser);
			logger.debug("changeStatusVideo End");
		} catch (Exception e) {
			logger.error(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

	/*
	 * (non-Javadoc) Phuong thuc lay tat ca video dang duoc kich hoat
	 * 
	 * @see vn.edu.vnua.dse.service.VideoService#getListVideoIsActive()
	 */
	@Override
	public List<Video> getListVideoIsActive() {
		List<Video> listResult = new ArrayList<Video>();
		try {
			logger.debug("getListVideoIsActive Start");
			listResult = videoDao.getListVideoIsActive();
			logger.debug("getListVideoIsActive End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

	/*
	 * (non-Javadoc) Phuong thuc lay limited video dang duoc kich hoat
	 * 
	 * @see vn.edu.vnua.dse.service.VideoService#getLimitVideoIsActive(int)
	 */
	@Override
	public List<Video> getLimitVideoIsActive(int startIndex) {
		List<Video> listResult = new ArrayList<Video>();
		try {
			logger.debug("getLimitVideoIsActive Start");
			listResult = videoDao.getLimitVideoIsActive(startIndex);
			logger.debug("getLimitVideoIsActive End");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listResult;
	}

}

package vn.edu.vnua.dse.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import vn.edu.vnua.dse.entity.Video;

public interface VideoDAO {

	public void setSessionFactory(SessionFactory sessionFactory);

	/**
	 * Phuong thuc lay tat ca video
	 * 
	 * @return
	 */
	public List<Video> getAllVideo();

	/**
	 * Phuong thuc lay litmited video
	 * 
	 * @return
	 */
	public List<Video> getLimitedVideo(int startIndex);

	/**
	 * Phuong thuc them moi 1 video
	 * 
	 * @param name
	 */
	public void addVideo(Video Video);

	/**
	 * Phuong thuc cap nhat 1 Video
	 * 
	 * @param name
	 */
	public void updateVideo(Video Video);

	/**
	 * Phuong thuc xoa 1 Video
	 * 
	 * @param videoId
	 */
	public void deleteVideo(int videoId);

	/**
	 * Phuong thuc thay doi trang thai cua 1 Video
	 * 
	 * @param videoId
	 */
	public void changeStatusVideo(int videoId, boolean status, String updateByUser);

	/**
	 * Phuong thuc lay tat ca video dang duoc kich hoat
	 * 
	 * @return
	 */
	public List<Video> getListVideoIsActive();
	
	/**
	 * Phuong thuc lay limited video dang duoc kich hoat
	 * 
	 * @return
	 */
	public List<Video> getLimitVideoIsActive(int startIndex);
	
	/**
	 * Lay danh sach tat ca video dang cho duyet
	 * 
	 * @return
	 */
	public List<Video> getPendingVideo();

	/**
	 * Lay danh sach 10 video dang cho duyet
	 * 
	 * @return
	 */
	public List<Video> getLimitPendingVideo(int startIndex);

	/**
	 * Lay danh sach tat ca video da duyet
	 * 
	 * @return
	 */
	public List<Video> getApprovedVideo();

	/**
	 * Lay danh sach 10 video da duyet
	 * 
	 * @return
	 */
	public List<Video> getLimitApprovedVideo(int startIndex);
	
	/**
	 * Lay danh sach tat ca video da dang
	 * 
	 * @return
	 */
	public List<Video> getPublishedVideo();

	/**
	 * Lay danh sach 10 video da dang
	 * 
	 * @return
	 */
	public List<Video> getLimitPublishedVideo(int startIndex);
	
	/**
	 * Phuong thuc lay video theo id
	 * 
	 * @param id
	 * @return
	 */
	public Video getVideoById(int id);
	
	/**
	 * Phuong thuc duyet video
	 * 
	 * @param videoId
	 */
	public void approved(int videoId, String approvedUser);

	/**
	 * Phuong thuc go video
	 * 
	 * @param videoId
	 */
	public void unapproved(int videoId, String unapprovedUser);

}

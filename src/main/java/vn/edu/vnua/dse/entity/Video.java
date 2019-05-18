package vn.edu.vnua.dse.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "video")
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String videoYoutubeId;
	private String title;
	private String shortContent;
	private String editor;
	private String author;
	private Date createdDate;
	private Date updatedDate;
	private String updatedUser;
	private Date publishedDate;
	private boolean status;
	private String avatarVideo;
	private String approvedUser;
	private String unApprovedUser;
	private User user;
	private boolean isPublic;

	public Video() {

	}

	public Video(int id, String videoYoutubeId, String title, String shortContent, String editor, String author,
			Date createdDate, Date updatedDate, String updatedUser, Date publishedDate, boolean status,
			String avatarVideo, String approvedUser, String unApprovedUser, User user, boolean isPublic) {
		super();
		this.id = id;
		this.videoYoutubeId = videoYoutubeId;
		this.title = title;
		this.shortContent = shortContent;
		this.editor = editor;
		this.author = author;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
		this.publishedDate = publishedDate;
		this.status = status;
		this.avatarVideo = avatarVideo;
		this.approvedUser = approvedUser;
		this.unApprovedUser = unApprovedUser;
		this.isPublic = isPublic;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "video_youtube_id", length = 255)
	public String getVideoYoutubeId() {
		return videoYoutubeId;
	}

	public void setVideoYoutubeId(String videoYoutubeId) {
		this.videoYoutubeId = videoYoutubeId;
	}

	@Column(name = "title", length = 255)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "short_content", length = 500)
	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	@Column(name = "editor", length = 50)
	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	@Column(name = "author", length = 50)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "updated_user", length = 50)
	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	@Column(name = "published_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Column(name = "status")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "avatar_video", length = 255)
	public String getAvatarVideo() {
		return avatarVideo;
	}

	public void setAvatarVideo(String avatarVideo) {
		this.avatarVideo = avatarVideo;
	}

	@Column(name = "approved_user", length = 50)
	public String getApprovedUser() {
		return approvedUser;
	}

	public void setApprovedUser(String approvedUser) {
		this.approvedUser = approvedUser;
	}

	@Column(name = "unapproved_user", length = 50)
	public String getUnApprovedUser() {
		return unApprovedUser;
	}

	public void setUnApprovedUser(String unApprovedUser) {
		this.unApprovedUser = unApprovedUser;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "public")
	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

}

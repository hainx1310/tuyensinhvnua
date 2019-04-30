package vn.edu.vnua.dse.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "post")
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String shortContent;
	private String title;
	private String url;
	private String avatarPost;
	private String content;
	private Categories categories;
	private String editor;
	private String author;
	private Date createdDate;
	private Date updatedDate;
	private String updatedUser;
	private Date publishedDate;
	private int status;
	private String approvedUser;
	private String unapprovedUser;
	private Collection<Comment> comments;

	public Post() {

	}

	public Post(int id, String shortContent, String title, String url, String avatarPost, String content,
			Categories categories, String editor, String author, Date createdDate, Date updatedDate, String updatedUser,
			Date publishedDate, int status, String approvedUser, String unapprovedUser, Collection<Comment> comments) {
		super();
		this.id = id;
		this.shortContent = shortContent;
		this.title = title;
		this.url = url;
		this.avatarPost = avatarPost;
		this.content = content;
		this.categories = categories;
		this.editor = editor;
		this.author = author;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
		this.publishedDate = publishedDate;
		this.status = status;
		this.approvedUser = approvedUser;
		this.unapprovedUser = unapprovedUser;
		this.comments = comments;
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

	@Column(name = "short_content", length = 500)
	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	@Column(name = "title", length = 255)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "url", length = 255)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "avatar_post", length = 255)
	public String getAvatarPost() {
		return avatarPost;
	}

	public void setAvatarPost(String avatarPost) {
		this.avatarPost = avatarPost;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	@JoinColumn(name = "categories_id")
	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
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
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
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
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "approved_user", length = 50)
	public String getApprovedUser() {
		return approvedUser;
	}

	public void setApprovedUser(String approvedUser) {
		this.approvedUser = approvedUser;
	}

	@Column(name = "unapproved_user", length = 50)
	public String getUnapprovedUser() {
		return unapprovedUser;
	}

	public void setUnapprovedUser(String unapprovedUser) {
		this.unapprovedUser = unapprovedUser;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

}

package vn.edu.vnua.des.co;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import vn.edu.vnua.dse.entity.Categories;
import vn.edu.vnua.dse.entity.Comment;

public class PostCO implements Serializable {

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

	public PostCO() {

	}

	public PostCO(int id, String shortContent, String title, String url, String avatarPost, String content,
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAvatarPost() {
		return avatarPost;
	}

	public void setAvatarPost(String avatarPost) {
		this.avatarPost = avatarPost;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getApprovedUser() {
		return approvedUser;
	}

	public void setApprovedUser(String approvedUser) {
		this.approvedUser = approvedUser;
	}

	public String getUnapprovedUser() {
		return unapprovedUser;
	}

	public void setUnapprovedUser(String unapprovedUser) {
		this.unapprovedUser = unapprovedUser;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

}

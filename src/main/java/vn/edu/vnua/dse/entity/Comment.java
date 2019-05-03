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
@Table(name = "comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private Post post;
	private String name;
	private String comment;
	private boolean status;
	private Date createdDate;

	public Comment() {

	}

	public Comment(int id, Post post, String name, String comment, boolean status, Date createdDate) {
		super();
		this.id = id;
		this.post = post;
		this.name = name;
		this.comment = comment;
		this.status = status;
		this.createdDate = createdDate;
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

	@ManyToOne
	@JoinColumn(name = "post_id")
	public Post getpost() {
		return post;
	}

	public void setpost(Post post) {
		this.post = post;
	}

	@Column(name = "name", length = 255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "comment", length = 255)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "status")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}

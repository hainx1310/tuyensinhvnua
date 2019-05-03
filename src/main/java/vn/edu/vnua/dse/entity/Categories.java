package vn.edu.vnua.dse.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categories")
public class Categories implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private Date createdDate;
	private String createdUser;
	private Date updatedDate;
	private String updatedUser;
	private Collection<Post> posts;
	private boolean status;

	public Categories() {

	}

	public Categories(int id, String name, Date createdDate, String createdUser, Date updatedDate, String updatedUser,
			Collection<Post> posts, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
		this.posts = posts;
		this.status = status;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Column(name = "created_user", length = 50)
	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
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

	@JsonIgnore
	@OneToMany(mappedBy = "categories", fetch = FetchType.EAGER)
	public Collection<Post> getPosts() {
		return posts;
	}

	public void setPosts(Collection<Post> posts) {
		this.posts = posts;
	}

	@Column(name = "status")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}

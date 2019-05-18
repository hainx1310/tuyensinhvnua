package vn.edu.vnua.dse.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String email;
	private String username;
	private String password;
	private String passwordSalt;
	private String passwordHash;
	private Date lastLogin;
	private Date createdDate;
	private String createdUser;
	private Date updatedDate;
	private String updatedUser;
	private boolean status;
	private String resetPasswordCode;
	private String avatarUrl;
	private String role;
	private Collection<Post> post;
	private Collection<Video> video;
	private Collection<Notification> notification;

	public User() {

	}

	public User(int id, String name, String email, String username, String password, String passwordSalt,
			String passwordHash, Date lastLogin, Date createdDate, String createdUser, Date updatedDate,
			String updatedUser, boolean status, String resetPasswordCode, String avatarUrl, String role,
			Collection<Post> post, Collection<Video> video, Collection<Notification> notification) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.passwordSalt = passwordSalt;
		this.passwordHash = passwordHash;
		this.lastLogin = lastLogin;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
		this.status = status;
		this.resetPasswordCode = resetPasswordCode;
		this.avatarUrl = avatarUrl;
		this.role = role;
		this.post = post;
		this.video = video;
		this.notification = notification;
	}

	public User(int id, String name, String email, String sdt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(name = "email", length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "username", length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 255)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "password_salt", length = 500)
	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	@Column(name = "password_hash", length = 500)
	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	@Column(name = "last_login")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
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

	@Column(name = "status")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "reset_password_code", length = 512)
	public String getResetPasswordCode() {
		return resetPasswordCode;
	}

	public void setResetPasswordCode(String resetPasswordCode) {
		this.resetPasswordCode = resetPasswordCode;
	}

	@Column(name = "avatar_url", length = 255)
	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	@Column(name = "role", length = 50)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	public Collection<Post> getPost() {
		return post;
	}

	public void setPost(Collection<Post> post) {
		this.post = post;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	public Collection<Video> getVideo() {
		return video;
	}

	public void setVideo(Collection<Video> video) {
		this.video = video;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	public Collection<Notification> getNotification() {
		return notification;
	}

	public void setNotification(Collection<Notification> notification) {
		this.notification = notification;
	}

	@Transient
	public String getRoleName() {
		String roleName = "";
		switch (this.role) {
		case "ROLE_ADMIN":
			roleName = "Quản trị viên";
			break;
		case "ROLE_EDITOR":
			roleName = "Biên tập viên";
			break;
		case "ROLE_COLLABORARATORS":
			roleName = "Cộng tác viên";
			break;
		default:
			roleName = "Cộng tác viên";
		}
		return roleName;
	}

}

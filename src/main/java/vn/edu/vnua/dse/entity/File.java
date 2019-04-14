package vn.edu.vnua.dse.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "file")
public class File implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String filePart;
	private String type;
	private Date createdDate;

	public File() {

	}

	public File(int id, String filePart, String type, Date createdDate) {
		super();
		this.id = id;
		this.filePart = filePart;
		this.type = type;
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

	@Column(name = "file_part", length = 255)
	public String getFilePart() {
		return filePart;
	}

	public void setFilePart(String filePart) {
		this.filePart = filePart;
	}

	@Column(name = "type", length = 255)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

}

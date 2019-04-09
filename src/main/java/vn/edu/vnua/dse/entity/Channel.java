package vn.edu.vnua.dse.entity;

import java.sql.Date;

public class Channel {

	private int Id;
	private String name;
	private String description;
	private Date createdAt;
	private Date modifileAt;
	private String createdBy;
	private String modifileBy;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifileAt() {
		return modifileAt;
	}

	public void setModifileAt(Date modifileAt) {
		this.modifileAt = modifileAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifileBy() {
		return modifileBy;
	}

	public void setModifileBy(String modifileBy) {
		this.modifileBy = modifileBy;
	}

}

package vn.edu.vnua.dse.entity;

import java.util.Date;

public class Post {

	private String title;
	private String summary;
	private String content;
	private String channelId;
	private Date publishedDate;

	public Post() {

	}

	public Post(String title, String summary, String content, String channelId, Date publishedDate) {
		super();
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.channelId = channelId;
		this.publishedDate = publishedDate;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

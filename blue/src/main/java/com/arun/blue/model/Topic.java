package com.arun.blue.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Topic implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	private int topicId;
	private String topicSubject;
	private String topicDescription;
	@Transient
	private MultipartFile topicMedia;
	private Date topicAddedTime;
	@ManyToOne
	@JoinColumn(name="clientid")
	@JsonIgnore
	private Client client;
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> comments;
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getTopicAddedTime() {
		return topicAddedTime;
	}
	public void setTopicAddedTime(Date topicAddedTime) {
		this.topicAddedTime = topicAddedTime;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicSubject() {
		return topicSubject;
	}
	public void setTopicSubject(String topicSubject) {
		this.topicSubject = topicSubject;
	}
	public String getTopicDescription() {
		return topicDescription;
	}
	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}
	public MultipartFile getTopicMedia() {
		return topicMedia;
	}
	public void setTopicMedia(MultipartFile topicMedia) {
		this.topicMedia = topicMedia;
	}
}

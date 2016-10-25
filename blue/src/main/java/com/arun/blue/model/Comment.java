package com.arun.blue.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Comment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	private int commentId;
	private String commentDescription;
	private Date commentAddedTime;
	@JoinColumn(name="clientid")
	@OneToOne
	private Client client;
	@ManyToOne
	@JoinColumn(name="postId")
	private Post post;
	@ManyToOne
	@JoinColumn(name="topicId")
	private Topic topic;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Date getCommentAddedTime() {
		return commentAddedTime;
	}
	public void setCommentAddedTime(Date commentAddedTime) {
		this.commentAddedTime = commentAddedTime;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentDescription() {
		return commentDescription;
	}
	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}
}

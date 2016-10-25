package com.arun.blue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Friend 
{
	@Id@GeneratedValue
	private int friendId;
	@NotEmpty(message="Friend Name Field Should not be empty")
	private String friendName;
	@NotEmpty(message="Friend's Email Id Field Should not be empty")
	private String friendEmailId;
	private boolean activityStatus;
	
	public boolean isActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(boolean activityStatus) {
		this.activityStatus = activityStatus;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getFriendEmailId() {
		return friendEmailId;
	}
	public void setFriendEmailId(String friendEmailId) {
		this.friendEmailId = friendEmailId;
	}
}

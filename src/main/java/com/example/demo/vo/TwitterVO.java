package com.example.demo.vo;

import java.util.Date;

public class TwitterVO {
	
	
	
	String user;
	Date postDate;
	String message;
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "tweet [user=" + user + ", postDate=" + postDate + ", message=" + message + "]";
	}
	
	

}

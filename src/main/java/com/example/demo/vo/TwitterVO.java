package com.example.demo.vo;

import java.util.Date;

public class TwitterVO {


	String index = "twitter";
	String type = "view";
	String id;
	String user;
	Date postDate;
	String message;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
		return "TwitterVO{" +
				"index='" + index + '\'' +
				", type='" + type + '\'' +
				", id='" + id + '\'' +
				", user='" + user + '\'' +
				", postDate=" + postDate +
				", message='" + message + '\'' +
				'}';
	}

}

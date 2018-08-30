package model;

import java.io.Serializable;

public class Comment implements Serializable {
	private String comment;
	private String user;
	private String type;
	
	public Comment(String comment, String user, String type) {
		this.comment = comment;
		this.user = user;
		this.type = type;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}

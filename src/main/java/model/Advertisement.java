package model;

import java.sql.Date;

public class Advertisement {
	
	private int adv_id;
	private String title;
	private String description;
	private Date created;
	private Date edited;
	private int user_id;
	
	public int getAdvID() {
		return adv_id;
	}
	public void setAdvID(int advID) {
		this.adv_id = advID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getEdited() {
		return edited;
	}
	public void setEdited(Date edited) {
		this.edited = edited;
	}
	public int getUserID() {
		return user_id;
	}
	public void setUserID(int userID) {
		this.user_id = userID;
	}
}

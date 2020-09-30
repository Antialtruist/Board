package model;

public class User {

	private int id;
	private String fullname;
	private String email;
	private int phone;
	
	public int getID() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	public String getFullName() {
		return fullname;
	}
	public void setFullName(String fullName) {
		this.fullname = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
}

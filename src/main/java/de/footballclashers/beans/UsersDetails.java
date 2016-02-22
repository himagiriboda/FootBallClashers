package de.footballclashers.beans;

public class UsersDetails {
	
	private String name;
	private String password;
	private String social_id;
	private byte[] avatarImage;
	private String email;
	private Integer points;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSocial_id() {
		return social_id;
	}
	public void setSocial_id(String social_id) {
		this.social_id = social_id;
	}
	public byte[] getAvatarImage() {
		return avatarImage;
	}
	public void setAvatarImage(byte[] avatarImage) {
		this.avatarImage = avatarImage;
	}
	
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

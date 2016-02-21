package de.footballclashers.beans;

public class UsersDetails {
	
	private String name;
	private String password;
	private String socialId;
	private byte[] avatarImage;
	private String emailId;
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
	public String getSocialId() {
		return socialId;
	}
	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}
	public byte[] getAvatarImage() {
		return avatarImage;
	}
	public void setAvatarImage(byte[] avatarImage) {
		this.avatarImage = avatarImage;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	
	
}

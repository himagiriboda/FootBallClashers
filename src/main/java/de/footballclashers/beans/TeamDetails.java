package de.footballclashers.beans;

public class TeamDetails {
	
	private Integer id;
	private String name;
	private byte[] avatarImage;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getAvatarImage() {
		return avatarImage;
	}
	public void setAvatarImage(byte[] avatarImage) {
		this.avatarImage = avatarImage;
	}
	
	
}

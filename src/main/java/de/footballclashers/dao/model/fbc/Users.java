package de.footballclashers.dao.model.fbc;

import java.io.Serializable;

public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String social_id;
	private byte[] avatarImage;
	private Byte points;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Byte getPoints() {
		return points;
	}
	public void setPoints(Byte points) {
		this.points = points;
	}
	
}

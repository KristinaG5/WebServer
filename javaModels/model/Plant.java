package model;

import java.io.Serializable;

public class Plant implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String funfact;
	private String family;
	private String location;
	private String bio;
	private String urlImg;
	
	public Plant(String name, String funfact, String family, String location, String bio, String urlImg) {
		this.name = name;
		this.funfact = funfact;
		this.family = family;
		this.location = location;
		this.bio = bio;
		this.urlImg = urlImg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunfact() {
		return funfact;
	}

	public void setFunfact(String funfact) {
		this.funfact = funfact;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setAnimalImg(String urlImg) {
		this.urlImg = urlImg;
	}
	
}
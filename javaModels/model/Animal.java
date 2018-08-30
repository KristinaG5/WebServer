package model;

import java.io.Serializable;

public class Animal implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String funfact;
	private String family;
	private String location;
	private String endangered;
	private String behaviours;
	private String bio;
	private String urlImg;
	
	public Animal(String name, String funfact, String family, String location, String endangered,
			String behaviours, String bio, String urlImg) {
		this.name = name;
		this.funfact = funfact;
		this.family = family;
		this.location = location;
		this.endangered = endangered;
		this.behaviours = behaviours;
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

	public String getEndangered() {
		return endangered;
	}

	public void setEndangered(String endangered) {
		this.endangered = endangered;
	}

	public String getBehaviours() {
		return behaviours;
	}

	public void setBehaviours(String behaviours) {
		this.behaviours = behaviours;
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
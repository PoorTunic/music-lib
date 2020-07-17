package com.uttec.entities;

import java.util.Date;

/**
 * 
 * @author Daniel Clemente Aguirre, Daniela Hernández Hernández, Juan Alberto
 *         Osorio Osorio
 * @version 1.0
 */
public class Artist {

	private Integer ID;
	private String name;
	private String artisticName;
	private String bio;
	private Date born;

	public Artist(Integer iD, String name, String artisticName, String bio, Date born) {
		super();
		ID = iD;
		this.name = name;
		this.artisticName = artisticName;
		this.bio = bio;
		this.born = born;
	}

	public Artist(String name, String artisticName, String bio, Date born) {
		super();
		this.name = name;
		this.artisticName = artisticName;
		this.bio = bio;
		this.born = born;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtisticName() {
		return artisticName;
	}

	public void setArtisticName(String artisticName) {
		this.artisticName = artisticName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

}

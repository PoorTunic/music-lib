package com.uttec.entities;

import java.util.Date;
import java.util.UUID;

/**
 * 
 * @author Daniel Clemente Aguirre, Daniela Hernández Hernández, Juan Alberto
 *         Osorio Osorio
 * @version 1.0
 */
public class Artist {

	private UUID id;
	private String name;
	private String artisticName;
	private String bio;
	private Date born;

	public Artist(String name, String artisticName, String bio, Date born) {
		super();
		this.name = name;
		this.artisticName = artisticName;
		this.bio = bio;
		this.born = born;
	}

	public Artist(UUID id, String name, String artisticName, String bio, Date born) {
		super();
		this.id = id;
		this.name = name;
		this.artisticName = artisticName;
		this.bio = bio;
		this.born = born;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", artisticName=" + artisticName + ", bio=" + bio + ", born="
				+ born + "]";
	}

}

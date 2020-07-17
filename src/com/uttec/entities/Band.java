package com.uttec.entities;

import java.util.List;

public class Band {

	private Integer ID;
	private String name;
	private List<Artist> artists;

	public Band(Integer iD, String name, List<Artist> artists) {
		super();
		ID = iD;
		this.name = name;
		this.artists = artists;
	}

	public Band(String name, List<Artist> artists) {
		super();
		this.name = name;
		this.artists = artists;
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

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

}

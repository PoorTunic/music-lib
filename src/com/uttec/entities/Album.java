package com.uttec.entities;

import java.util.Date;
import java.util.List;

public class Album {

	private Integer ID;
	private String name;
	private Date departure;
	private Integer genreID;

	private Band band;
	private List<Song> songs;

	public Album(Integer iD) {
		super();
		ID = iD;
	}

	public Album(Integer iD, String name, Date departure, Integer genreID, Band band, List<Song> songs) {
		super();
		ID = iD;
		this.name = name;
		this.departure = departure;
		this.genreID = genreID;
		this.band = band;
		this.songs = songs;
	}

	public Album(String name, Date departure, Integer genreID, Band band, List<Song> songs) {
		super();
		this.name = name;
		this.departure = departure;
		this.genreID = genreID;
		this.band = band;
		this.songs = songs;
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

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public Integer getGenreID() {
		return genreID;
	}

	public void setGenreID(Integer genreID) {
		this.genreID = genreID;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Album [ID=" + ID + ", name=" + name + ", departure=" + departure + ", genreID=" + genreID + ", band="
				+ band + ", songs=" + songs + "]";
	}
}

package com.uttec.entities;

import java.util.Date;
import java.util.List;

public class Album {

	private Integer ID;
	private String name;
	private Date departure;
	private String genre;

	private Band band;
	private List<Song> songs;

	public Album(Integer iD, String name, Date departure, String genre, Band band, List<Song> songs) {
		super();
		ID = iD;
		this.name = name;
		this.departure = departure;
		this.genre = genre;
		this.band = band;
		this.songs = songs;
	}

	public Album(String name, Date departure, String genre, Band band, List<Song> songs) {
		super();
		this.name = name;
		this.departure = departure;
		this.genre = genre;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
		return "Album [ID=" + ID + ", name=" + name + ", departure=" + departure + ", genre=" + genre + ", songs="
				+ songs + "]";
	}
}

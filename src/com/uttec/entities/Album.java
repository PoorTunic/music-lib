package com.uttec.entities;

import java.util.Date;
import java.util.List;

public class Album {

	private Integer ID;
	private String name;
	private Date departure;
	private String genre;

	private List<Song> songs;

	public Album(Integer iD, String name, Date departure, String genre, List<Song> songs) {
		super();
		ID = iD;
		this.name = name;
		this.departure = departure;
		this.genre = genre;
		this.songs = songs;
	}

	public Album(String name, Date departure, String genre, List<Song> songs) {
		super();
		this.name = name;
		this.departure = departure;
		this.genre = genre;
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

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
}

package com.uttec.entities;

import java.util.Date;

public class Song {

	private Integer ID;
	private String name;
	private Date release;
	private String comment;

	public Song(Integer iD, String name, Date release, String comment) {
		super();
		ID = iD;
		this.name = name;
		this.release = release;
		this.comment = comment;
	}

	public Song(String name, Date release, String comment) {
		super();
		this.name = name;
		this.release = release;
		this.comment = comment;
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

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

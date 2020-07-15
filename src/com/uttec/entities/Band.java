package com.uttec.entities;

import java.util.List;
import java.util.UUID;

public class Band {

	private UUID id;
	private String name;
	private List<Artist> artists;

	public Band(String name, List<Artist> artists) {
		super();
		this.name = name;
		this.artists = artists;
	}

	public Band(UUID id, String name, List<Artist> artists) {
		super();
		this.id = id;
		this.name = name;
		this.artists = artists;
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

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	@Override
	public String toString() {
		return "Band [id=" + id + ", name=" + name + ", artists=" + artists + "]";
	}
}

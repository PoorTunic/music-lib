package com.uttec.entities;

import java.util.UUID;

public class Band {

	private UUID id;
	private String name;

	public Band() {

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

	@Override
	public String toString() {
		return "Band [id=" + id + ", name=" + name + "]";
	}

}

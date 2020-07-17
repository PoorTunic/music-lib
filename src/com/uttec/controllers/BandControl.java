package com.uttec.controllers;

import java.util.List;

import com.uttec.controllers.interfaces.AlbumSearcher;
import com.uttec.entities.Album;

public class BandControl implements AlbumSearcher<Album> {

	@Override
	public List<Album> findByName(String name) {
		return null;
	}
}

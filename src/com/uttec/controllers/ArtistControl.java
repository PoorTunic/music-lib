package com.uttec.controllers;

import java.util.List;

import com.uttec.controllers.interfaces.AlbumSearcher;
import com.uttec.entities.Album;
import com.uttec.entities.Artist;
import com.uttec.entities.Band;

public class ArtistControl implements AlbumSearcher<Album> {

	public static void save(List<Artist> artists) {

	}

	public static void save(Band newBand) {

	}

	@Override
	public List<Album> findByName(String name) {
		return null;
	}

}

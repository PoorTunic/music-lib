package com.uttec.controllers;

import java.util.List;

import com.uttec.controllers.interfaces.AlbumSearcher;
import com.uttec.entities.Album;

public class AlbumControl implements AlbumSearcher<Album> {

	public static void save(Album album) {

	}

	@Override
	public List<Album> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

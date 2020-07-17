package com.uttec.controllers;

import java.util.List;

import com.uttec.controllers.interfaces.AlbumSearcher;
import com.uttec.entities.Album;

public class SearcherContext {

	private AlbumSearcher<Album> context;

	public SearcherContext(AlbumSearcher<Album> context) {
		this.context = context;
	}

	public List<Album> search(String name) {
		return context.findByName(name);
	}

}

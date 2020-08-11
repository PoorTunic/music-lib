package com.uttec.controllers;

import java.util.List;

import com.uttec.controllers.interfaces.AlbumSearcher;
import com.uttec.entities.Album;

/**
 * Represents the context to fetch albums data
 * 
 * @author Daniel Clemente Aguirre, Daniela Hernández Hernández, Juan Alberto
 *         Osorio Osorio
 *
 */
public class SearcherContext {

	/**
	 * Represents a Context to search in DB
	 */
	private AlbumSearcher<Album> context;

	/**
	 * Constructor with provided context to search in DB
	 * 
	 * @param context Provided context applied to search Albums
	 */
	public SearcherContext(AlbumSearcher<Album> context) {
		this.context = context;
	}

	/**
	 * Depending on the given context, this will apply the method findByName
	 * 
	 * @param name to find
	 * @return List of Albums
	 */
	public List<Album> search(String name) {
		return context.findByName(name);
	}

}

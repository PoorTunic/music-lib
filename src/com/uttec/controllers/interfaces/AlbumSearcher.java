package com.uttec.controllers.interfaces;

import java.util.List;

/**
 * Represents the Album Searcher
 * 
 * @author Daniel Clemente Aguirre, Daniela Hern�ndez Hern�ndez, Juan Alberto
 *         Osorio Osorio
 *
 * @param <Album> Only Album references are allowed
 */
public interface AlbumSearcher<Album> {

	public List<Album> findByName(String name);
}

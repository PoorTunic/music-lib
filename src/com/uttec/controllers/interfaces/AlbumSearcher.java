package com.uttec.controllers.interfaces;

import java.util.List;

public interface AlbumSearcher<Album> {

	public List<Album> findByName(String name);
}

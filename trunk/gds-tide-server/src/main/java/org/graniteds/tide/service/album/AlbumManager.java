package org.graniteds.tide.service.album;

import java.util.List;

import org.graniteds.tide.model.Album;

public interface AlbumManager
{

	void save(Album album);
	
	void update(Album album);
	
	void remove(Album album);

	Album getAlbum(String id);

	List<Album> getAllAlbums();

}

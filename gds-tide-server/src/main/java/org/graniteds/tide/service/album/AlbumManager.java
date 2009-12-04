package org.graniteds.tide.service.album;

import java.util.List;

import org.graniteds.tide.model.Album;
import org.springframework.security.annotation.Secured;

public interface AlbumManager
{
	
	@Secured({"ROLE_EDIT"})
	void save(Album album);
	
	void update(Album album);
	
	void remove(Album album);

	Album getAlbum(String id);

	List<Album> getAllAlbums();

}

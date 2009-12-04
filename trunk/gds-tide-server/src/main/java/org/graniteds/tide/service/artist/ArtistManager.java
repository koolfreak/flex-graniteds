package org.graniteds.tide.service.artist;

import java.util.List;

import org.graniteds.tide.model.Artist;

public interface ArtistManager {
		
	public Artist createArtist(String name);
	public Artist getArtist(String id) throws Exception;
	public List<Artist> getAllArtists();
	public Artist saveArtist(String id, String name) throws Exception;
	boolean login(String user, String pass);
	
}

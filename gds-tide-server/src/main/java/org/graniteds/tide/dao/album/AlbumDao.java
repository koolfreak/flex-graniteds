/**
 * 
 */
package org.graniteds.tide.dao.album;

import java.util.List;

import org.graniteds.tide.model.Album;
import org.springframework.dao.DataAccessException;

/**
 * @author Emmanuel Nollase - emanux
 * @created 2009 12 2 - 11:24:34
 * 
 */
public interface AlbumDao
{

	void save(Album album) throws DataAccessException;

	void update(Album album) throws DataAccessException;

	void remove(Album album) throws DataAccessException;

	Album getAlbum(String id) throws DataAccessException;
	
	Album getTrackAlbum(String id) throws DataAccessException;

	List<Album> loadAll() throws DataAccessException;
}

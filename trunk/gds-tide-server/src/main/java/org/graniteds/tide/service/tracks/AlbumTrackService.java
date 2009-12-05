/**
 * 
 */
package org.graniteds.tide.service.tracks;

import org.graniteds.tide.model.Track;

/**
 * @author Emmanuel Nollase - emanux
 * @created 2009 12 5 - 19:10:43
 * 
 */
public interface AlbumTrackService
{

	void save(Track track);
	
	void remove(Track track);
	
	void update(Track track);
}

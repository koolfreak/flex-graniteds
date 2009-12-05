/**
 * 
 */
package org.graniteds.tide.service.tracks;

import org.graniteds.tide.dao.track.TrackDao;
import org.graniteds.tide.model.Track;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Emmanuel Nollase - emanux
 * @created 2009 12 5 - 19:11:13
 * 
 */
public class AlbumTrackServiceImpl implements AlbumTrackService
{
	@Autowired private TrackDao trackDao;
	
	/* (non-Javadoc)
	 * @see org.graniteds.tide.service.tracks.AlbumTrackService#save(org.graniteds.tide.model.Track)
	 */
	public void save(Track track)
	{
		trackDao.save(track);
	}
	/* (non-Javadoc)
	 * @see org.graniteds.tide.service.tracks.AlbumTrackService#remove(org.graniteds.tide.model.Track)
	 */
	public void remove(Track track)
	{
		trackDao.delete(track);
	}
	/* (non-Javadoc)
	 * @see org.graniteds.tide.service.tracks.AlbumTrackService#update(org.graniteds.tide.model.Track)
	 */
	public void update(Track track)
	{
		trackDao.update(track);
	}

}

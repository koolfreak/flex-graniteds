package org.graniteds.tide.service.album;

import java.util.List;

import org.graniteds.tide.dao.album.AlbumDao;
import org.graniteds.tide.model.Album;
import org.graniteds.tide.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("albumService")
public class AlbumManagerImpl implements AlbumManager
{

	@Autowired private AlbumDao albumDao;
	
	/*
	 * (non-Javadoc)
	 * @see org.graniteds.tide.service.album.AlbumManager#save(org.graniteds.tide.model.Album)
	 */
	public void save(Album album)
	{
		if( !album.getAlbumTracks().isEmpty() )
		{
			final List<Track> tracks = album.getAlbumTracks();
			for (Track track : tracks)
			{
				track.setAlbum(album);
			}
		}
		albumDao.save(album);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.graniteds.tide.service.album.AlbumManager#getAlbum(java.lang.String)
	 */
	public Album getAlbum(String id)
	{
		return albumDao.getAlbum(id);
	}

	/*
	 * (non-Javadoc)
	 * @see org.graniteds.tide.service.album.AlbumManager#getAllAlbums()
	 */
	public List<Album> getAllAlbums()
	{
		return albumDao.loadAll();
	}


	/* (non-Javadoc)
	 * @see org.graniteds.tide.service.album.AlbumManager#remove(org.graniteds.tide.model.Album)
	 */
	public void remove(Album album)
	{
		final Album _album = getAlbum(album.getId());
		albumDao.remove(_album);
	}


	/* (non-Javadoc)
	 * @see org.graniteds.tide.service.album.AlbumManager#update(org.graniteds.tide.model.Album)
	 */
	public void update(Album album)
	{
		albumDao.update(album);
	}

	/* (non-Javadoc)
	 * @see org.graniteds.tide.service.album.AlbumManager#getTrackAlbum(java.lang.String)
	 */
	public Album getTrackAlbum(String id)
	{
		return albumDao.getTrackAlbum(id);
	}


}

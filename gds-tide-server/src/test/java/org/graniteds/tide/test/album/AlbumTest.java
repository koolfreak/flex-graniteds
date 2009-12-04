/**
 * 
 */
package org.graniteds.tide.test.album;

import java.util.List;

import org.graniteds.tide.model.Album;
import org.graniteds.tide.model.Duration;
import org.graniteds.tide.model.Track;
import org.graniteds.tide.service.album.AlbumManager;
import org.graniteds.tide.test.BaseGraniteDSTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Emmanuel Nollase - emanux
 * @created 2009 12 2 - 10:29:43
 * 
 */
public class AlbumTest extends BaseGraniteDSTest
{

	@Autowired private AlbumManager albumManager;
	
	//@Test
	public void loadDataAlbumsTest()
	{
		Album album = new Album();
		album.setDuration(new Duration(1, 20, 20));
		album.setName("RedHotChilliPeppers");
		album.setYear(1999);
		albumManager.save(album);
		//albumDao.save(new Album("2", "RageAgainstTheMachine", 1995, new Duration(1, 20, 20)));
		//albumDao.save(new Album("3", "Blink182", 1999, new Duration(1, 20, 20)));
	}
	
	@Test
	public void getAlbumTracks() 
	{
		List<Album> _albums = albumManager.getAllAlbums();
		for(Album album : _albums)
		{
			List<Track> _tracks = album.getAlbumTracks();
			for(Track track : _tracks)
			{
				System.out.println(track.getTitle());
			}
		}
	}
}

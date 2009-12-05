/**
 * 
 */
package org.graniteds.tide.test.album;

import java.util.ArrayList;
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
	
	@Test
	public void loadDataAlbumsTest()
	{
		Album album = new Album();
		album.setDuration(new Duration(1, 20, 20));
		album.setName("RedHotChilliPeppers");
		album.setYear(1999);
		
		Track track = null;
		List<Track> tracks = new ArrayList<Track>();
		
		track = new Track();
		track.setTitle("1");
		track.setAlbum(album);
		tracks.add(track);
		
		track = new Track();
		track.setTitle("2");
		track.setAlbum(album);
		tracks.add(track);
		
		album.setAlbumTracks(tracks);
		albumManager.save(album);
	}
	
	/*@Test
	public void getAlbumTracks() 
	{
		Album album = albumManager.getAlbum("ff808181255df0cc01255df0d1020001");
		//assertNotNull(album.getAlbumTracks().get(0).getTitle());
		System.out.println(album.getAlbumTracks().get(0).getTitle());
		//System.out.println(_tracks.size());
		for (Track track : _tracks)
		{
			System.out.println("track title: "+track.getTitle());
		}
		//assertNotNull(_tracks);
	}*/
	
	/*@Test
	public void deleteAlbumTest()
	{
		Album album = albumManager.getAlbum("ff808181255e136801255e141be10001");
		albumManager.remove(album);
	}*/
}

package org.graniteds.tide.service.artist;

import java.util.ArrayList;
import java.util.List;

import org.graniteds.tide.model.Artist;
import org.springframework.stereotype.Service;

@Service("artistService")
public class ArtistManagerImpl implements ArtistManager {
	
	private List<Artist> artistsS = new ArrayList<Artist>();
	
	public ArtistManagerImpl()
	{
		artistsS.add(new Artist("0", "Black Eyed Peas"));
		artistsS.add(new Artist("1", "David Guetta"));
		artistsS.add(new Artist("2", "Muse"));
	}
	
	public Artist createArtist(String name) {
		Artist a = new Artist("100", name);
		artistsS.add(a);
		return a;
	}

	public Artist getArtist(String id) throws Exception {
		int s = artistsS.size();
		Artist a;
		for(int i=0;i<s;i++)
		{
			a = artistsS.get(i);
			if(a.getId() == id)
			{
				return a;
			}
		}
		throw new Exception("Artist not found");
	}

	public List<Artist> getAllArtists() {
		return artistsS;
	}
	
	public Artist saveArtist(String id, String name) throws Exception {
		Artist a = null;
		int s = artistsS.size();
		for(int i=0;i<s;i++)
		{
			a = artistsS.get(i);
			if(a.getId() == id)
			{
				a.setName(name);
				return a;
			}
		}
		if(a == null)
		{
			throw new Exception("Artist not found");
		}
		return a;
	}

	/* (non-Javadoc)
	 * @see org.granite.tide.test.services.ArtistManager#login(java.lang.String, java.lang.String)
	 */
	public boolean login(String user, String pass)
	{
		System.out.println("ArtistManagerImpl.login()");
		return false;
	}
}

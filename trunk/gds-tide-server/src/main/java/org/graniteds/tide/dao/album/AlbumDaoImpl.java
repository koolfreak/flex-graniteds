/**
 * 
 */
package org.graniteds.tide.dao.album;

import java.util.List;

import org.graniteds.tide.model.Album;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Emmanuel Nollase - emanux
 * @created 2009 12 2 - 11:25:39
 * 
 */
public class AlbumDaoImpl extends HibernateDaoSupport implements AlbumDao
{

	/* (non-Javadoc)
	 * @see org.graniteds.tide.dao.album.AlbumDao#save(org.graniteds.tide.model.Album)
	 */
	public void save(Album album) throws DataAccessException
	{
		getHibernateTemplate().saveOrUpdate(album);
	}

	/* (non-Javadoc)
	 * @see org.graniteds.tide.dao.album.AlbumDao#loadAll()
	 */
	@SuppressWarnings("unchecked")
	public List<Album> loadAll() throws DataAccessException
	{
		return this.getSession().createCriteria(Album.class).list();
	}

	/* (non-Javadoc)
	 * @see org.graniteds.tide.dao.album.AlbumDao#getAlbum(java.lang.String)
	 */
	public Album getAlbum(String id) throws DataAccessException
	{
		return (Album) getHibernateTemplate().load(Album.class, id);
	}

	/* (non-Javadoc)
	 * @see org.graniteds.tide.dao.album.AlbumDao#remove(org.graniteds.tide.model.Album)
	 */
	public void remove(Album album) throws DataAccessException
	{
		getHibernateTemplate().delete(album);
	}

	/* (non-Javadoc)
	 * @see org.graniteds.tide.dao.album.AlbumDao#update(org.graniteds.tide.model.Album)
	 */
	public void update(Album album) throws DataAccessException
	{
		getHibernateTemplate().merge(album);
	}

	/* (non-Javadoc)
	 * @see org.graniteds.tide.dao.album.AlbumDao#getTrackAlbum(java.lang.String)
	 */
	public Album getTrackAlbum(String id) throws DataAccessException
	{
		return (Album) this.getSession().createCriteria(Album.class).add(Restrictions.eq("id", id))
		.setFetchMode("albumTracks", FetchMode.JOIN).uniqueResult();
	}

}

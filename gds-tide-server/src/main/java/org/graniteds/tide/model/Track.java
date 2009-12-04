package org.graniteds.tide.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Table(name = "tbl_tracks")
public class Track implements Serializable
{

	@Id()
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", length = 32)
	private String id;

	@Basic
	@Column
	private int orderNum;

	@Basic
	@Column
	private String title;

	@ManyToOne
	private Album album;

	@Embedded
	private Duration duration;

	@OneToMany(mappedBy = "track",cascade=CascadeType.ALL)
	private List<Artist> trackArtists;

	public Track()
	{
		super();
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getOrderNum()
	{
		return orderNum;
	}

	public void setOrderNum(int orderNum)
	{
		this.orderNum = orderNum;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Duration getDuration()
	{
		return duration;
	}

	public void setDuration(Duration duration)
	{
		this.duration = duration;
	}

	public List<Artist> getTrackArtists()
	{
		return trackArtists;
	}

	public void setTrackArtists(List<Artist> trackArtists)
	{
		this.trackArtists = trackArtists;
	}

	public Album getAlbum()
	{
		return album;
	}

	public void setAlbum(Album album)
	{
		this.album = album;
	}

	@Override
	public boolean equals(Object obj)
	{
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode()
	{
		return HashCodeBuilder.reflectionHashCode(this);
	}
}

package org.graniteds.tide.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Table(name = "tbl_albums")
public class Album implements Serializable
{

	@Id()
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", length = 32)
	private String id;

	@Basic
	@Column
	private String name;

	@Basic
	@Column
	private int year;

	@Embedded
	private Duration duration;

	@OneToMany(mappedBy = "album",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Track> albumTracks;

	public Album()
	{
		super();
	}

	public Album(String id, String name, int year, Duration duration)
	{
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.duration = duration;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public Duration getDuration()
	{
		return duration;
	}

	public void setDuration(Duration duration)
	{
		this.duration = duration;
	}

	public List<Track> getAlbumTracks()
	{
		return albumTracks;
	}

	public void setAlbumTracks(List<Track> albumTracks)
	{
		this.albumTracks = albumTracks;
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

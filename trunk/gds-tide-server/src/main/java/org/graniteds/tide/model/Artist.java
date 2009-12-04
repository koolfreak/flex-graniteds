package org.graniteds.tide.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Table(name = "tbl_artist")
public class Artist implements Serializable
{

	@Id()
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", length = 32)
	private String id;

	@Basic
	@Column
	private String name;
	
	@ManyToOne
	private Track track;

	public Artist()
	{
		super();
	}

	public Artist(String id, String name)
	{
		super();
		this.id = id;
		this.name = name;
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

	public Track getTrack()
	{
		return track;
	}

	public void setTrack(Track track)
	{
		this.track = track;
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

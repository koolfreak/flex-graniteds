package org.graniteds.tide.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Duration implements Serializable
{

	@Basic
	@Column
	private int hours;
	
	@Basic
	@Column
	private int minutes;
	
	@Basic
	@Column
	private int seconds;

	public Duration()
	{
		super();
	}

	public Duration(int hours, int minutes, int seconds)
	{
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public int getHours()
	{
		return hours;
	}

	public void setHours(int hours)
	{
		this.hours = hours;
	}

	public int getMinutes()
	{
		return minutes;
	}

	public void setMinutes(int minutes)
	{
		this.minutes = minutes;
	}

	public int getSeconds()
	{
		return seconds;
	}

	public void setSeconds(int seconds)
	{
		this.seconds = seconds;
	}

}

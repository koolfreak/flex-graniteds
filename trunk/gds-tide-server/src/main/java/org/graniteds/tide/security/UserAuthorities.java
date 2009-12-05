/**
 * 
 */
package org.graniteds.tide.security;

import java.io.Serializable;

import org.springframework.security.GrantedAuthority;

/**
 * @author Emmanuel Nollase
 * @created Feb 9, 2009 - 12:53:27 PM
 */
public class UserAuthorities implements GrantedAuthority, Serializable
{

	private String authority;

	public UserAuthorities(String auth)
	{
		this.authority = auth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.GrantedAuthority#getAuthority()
	 */
	public String getAuthority()
	{
		return authority;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o)
	{
		return ((UserAuthorities) o).authority.compareTo(this.authority);
	}

}

/**
 * 
 */
package org.graniteds.tide.security;

import java.io.Serializable;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

/**
 * @author Emmanuel A. Nollase - emanux
 * @created Feb 10, 2009 - 3:49:40 PM
 * 
 */

public class AuthUser implements UserDetails, Serializable
{

	private GrantedAuthority[] authorities;

	private String password;

	private String username;

	private boolean accountNonExpired = true;

	private boolean accountNonLocked = true;

	private boolean credentialsNonExpired = true;

	private boolean enabled;

	public AuthUser(GrantedAuthority[] authorities, String password,
			String username, boolean enabled)
	{
		this.authorities = authorities;
		this.password = password;
		this.username = username;
		this.enabled = enabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#getAuthorities()
	 */
	public GrantedAuthority[] getAuthorities()
	{
		return authorities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.userdetails.UserDetails#getPassword()
	 */
	public String getPassword()
	{
		return password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.userdetails.UserDetails#getUsername()
	 */
	public String getUsername()
	{
		return username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#isAccountNonExpired
	 * ()
	 */
	public boolean isAccountNonExpired()
	{
		// TODO Auto-generated method stub
		return accountNonExpired;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#isAccountNonLocked()
	 */
	public boolean isAccountNonLocked()
	{
		// TODO Auto-generated method stub
		return accountNonLocked;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#isCredentialsNonExpired
	 * ()
	 */
	public boolean isCredentialsNonExpired()
	{
		// TODO Auto-generated method stub
		return credentialsNonExpired;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.userdetails.UserDetails#isEnabled()
	 */
	public boolean isEnabled()
	{
		// TODO Auto-generated method stub
		return enabled;
	}

}

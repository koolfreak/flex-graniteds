package org.graniteds.tide.service;

import org.graniteds.tide.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.security.annotation.Secured;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

public interface UserManager extends UserDetailsService
{

	@Secured({"ROLE_EDIT"})
	void save(User user);

	void remove(User user);

	void update(User user);

	UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException;

}

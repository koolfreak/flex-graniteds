package org.graniteds.tide.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.graniteds.tide.dao.user.UserDao;
import org.graniteds.tide.model.User;
import org.graniteds.tide.security.AuthUser;
import org.graniteds.tide.security.UserAuthorities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("loginService")
public class UserManagerImpl implements UserManager
{

	private static final Log logger = LogFactory.getLog(UserManagerImpl.class);
	private static final List<String> ROLES = Arrays.asList(new String[]{"ROLE_USER","ROLE_ADMIN"});
	
	@Autowired private UserDao userDao;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException
	{
		
		final User user = userDao.loadByUsername(username);
		if(user != null)
		{
			// TODO get the user roles in DB
			
			final int _size = ROLES.size();
			final UserAuthorities[] userAuths = new UserAuthorities[_size];
			for (int i = 0; i < _size; i++)
			{
				userAuths[i] = new UserAuthorities(ROLES.get(i));
			}
			
			return new AuthUser(userAuths, user.getPassword(), user
					.getUsername(), user.isEnabled());
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.graniteds.tide.service.UserManager#remove(org.graniteds.tide.model.User)
	 */
	public void remove(User user)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.graniteds.tide.service.UserManager#save(org.graniteds.tide.model.User)
	 */
	public void save(User user)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.graniteds.tide.service.UserManager#update(org.graniteds.tide.model.User)
	 */
	public void update(User user)
	{
		// TODO Auto-generated method stub
		
	}
}

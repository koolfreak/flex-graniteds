package org.graniteds.tide.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.annotation.security.RolesAllowed;
import org.springframework.stereotype.Service;

import org.graniteds.tide.model.User;

@Service("loginService")
public class LoginManagerImpl implements LoginManager {
	
	private static final Log logger = LogFactory.getLog(LoginManagerImpl.class);

	
	/* (non-Javadoc)
	 * @see com.atosorigin.services.impl.UserManager#login(java.lang.String, java.lang.String)
	 */
	@RolesAllowed("ROLE_ADMIN")
	public User loginCgeNga(String login, String pass) throws Exception {
		
		if (logger.isDebugEnabled()) logger.debug("IN LOGIN");
		System.out.println("LoginManagerImpl.loginCgeNga()");
		User user = null;
		
		if (login.equals("admin")){
			user = new User("admin", "admin" );			
		}
		else if(login.equals("ens")) {
			user = new User("ens", "enseignant" );
		}
		else if(login.equals("etu1")) {
			user = new User("etu1", "etu1" );
		}
		
		else {
			throw new Exception("le user est pas bon");
		}
		
		return user;
	}

	//@RolesAllowed("ROLE_ADMIN")
	public String sayHello(String name) {
		if (logger.isDebugEnabled()) logger.debug("IN TEST");
		return "hello: "+name;
		
	}
}

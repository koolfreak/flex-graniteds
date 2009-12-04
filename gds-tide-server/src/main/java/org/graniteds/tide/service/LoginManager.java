package org.graniteds.tide.service;

import org.graniteds.tide.model.User;

public interface LoginManager {

	User loginCgeNga(String login, String pass) throws Exception;
	
	String sayHello(String name);

}

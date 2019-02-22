package com.stackroute.accountmanager.service;

import java.util.Map;

import com.stackroute.accountmanager.model.User;

public interface JWTGenerator {
	
	/**Method declaration for Json Web Token Generator 
	 * 
	 * @param user
	 * @return
	 */
	Map<String, String> generateToken(User user);
}

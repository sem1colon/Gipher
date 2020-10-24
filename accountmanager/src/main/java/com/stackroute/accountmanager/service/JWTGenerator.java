package com.stackroute.accountmanager.service;

import com.stackroute.accountmanager.model.User;

import java.util.Map;

public interface JWTGenerator {
	
	/**Method declaration for Json Web Token Generator 
	 * 
	 * @param user
	 * @return
	 */
	Map<String, String> generateToken(User user);
}

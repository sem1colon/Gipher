package com.stackroute.accountmanager.service;

import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.User;

public interface UserService {
	
	/** Method declaration for saving user(signup)
	 * 
	 * @param user
	 * @return signupStatus(boolean)
	 * @throws UserAlreadyExistsException
	 */
	boolean saveUser(User user) throws UserAlreadyExistsException;

	/** Method declaration for authentication
	 * 
	 * @param user
	 * @return token
	 * @throws UserNotFoundException
	 */
	User authenticate(User user) throws UserNotFoundException;
}

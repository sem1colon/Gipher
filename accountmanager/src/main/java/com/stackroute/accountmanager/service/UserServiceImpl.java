package com.stackroute.accountmanager.service;

import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.User;
import com.stackroute.accountmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean saveUser(final User user) throws UserAlreadyExistsException {
		Optional<User> existingUser = userRepository.findByUserId(user.getUserId());
		if (existingUser.isPresent()) {
			throw new UserAlreadyExistsException("User already exists!");
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		System.out.println(user);
		userRepository.save(user);
		return true;
	}

	@Override
	public User authenticate(final User loginDetails) throws UserNotFoundException {
		Optional<User> actualUser = userRepository.findByUserId(loginDetails.getUserId());
		if (!actualUser.isPresent()) {
			throw new UserNotFoundException("Invalid Credentials!");
		}else if(!bCryptPasswordEncoder.matches(loginDetails.getPassword(), actualUser.get().getPassword())) {
			throw new UserNotFoundException("Invalid Credentials!");
		}
		return loginDetails;
	}

}

package com.stackroute.accountmanager.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.User;
import com.stackroute.accountmanager.repository.UserRepository;

public class UserServiceTest {
	@Mock
	private UserRepository userRepository;

	private User user;

	@InjectMocks
	private UserServiceImpl service;

	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private Optional<User> options;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		user = new User("johncena", "John Sena", "123456");
		options = Optional.of(user);
	}

	@Test
	public void testSaveUserSuccess() throws UserAlreadyExistsException {
		when(userRepository.save(user)).thenReturn(user);
		when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn(user.getPassword());
		boolean flag = service.saveUser(user);
		assertEquals("Cannot register user!", true, flag);
		verify(userRepository, times(1)).save(user);
	}

	@Test(expected = UserAlreadyExistsException.class)
	public void testSaveUserFailure() throws UserAlreadyExistsException {
		when(userRepository.findByUserId(user.getUserId())).thenReturn(options);
		when(userRepository.save(user)).thenReturn(user);
		boolean flag = service.saveUser(user);
		assertTrue("Saving user failed!", flag);
		verify(userRepository, times(1)).findById(user.getUserId());
	}

	@Test
	public void testValidateSuccess() throws UserNotFoundException {
		when(userRepository.findByUserId(user.getUserId())).thenReturn(options);
		when(bCryptPasswordEncoder.encode(options.get().getPassword())).thenReturn(options.get().getPassword());
		assertEquals(options.get().getUserId(), user.getUserId());
	}

	@Test(expected = UserNotFoundException.class)
	public void testValidateFailure() throws UserNotFoundException {
		when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn(user.getPassword());
		when(userRepository.findById("john")).thenReturn(null);
		service.authenticate(user);
	}

}

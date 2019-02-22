package com.stackroute.accountmanager.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.accountmanager.exception.UserAlreadyExistsException;
import com.stackroute.accountmanager.model.User;
import com.stackroute.accountmanager.service.JWTGenerator;
import com.stackroute.accountmanager.service.UserService;

@RestController
@RequestMapping("/api/v1/userservice")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private JWTGenerator tokenGenerator;
	ResponseEntity<?> responseEntity;

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody final User user) {
		try {
			System.out.println(user);
			userService.saveUser(user);
			responseEntity = new ResponseEntity<String>("Signup successful!", HttpStatus.CREATED);
		} catch (UserAlreadyExistsException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(),
					HttpStatus.CONFLICT);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("System Error!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody final User loginDetails) {
		try {
			if (null == loginDetails.getUserId() || null == loginDetails.getPassword()) {
				throw new Exception("User Id or Password cannot be empty!");
			}
			User user = userService.authenticate(loginDetails);
			Map<String, String> map = tokenGenerator.generateToken(user);
			responseEntity = new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);

		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(),
					HttpStatus.UNAUTHORIZED);
		}
		return responseEntity;
	}
}

package com.stackroute.accountmanager.service;

import com.stackroute.accountmanager.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTGeneratorImpl implements JWTGenerator {
	public static final String SECRET_KEY = "cognizant";

	@Override
	public Map<String, String> generateToken(final User user) {
		String token = "";
		token = Jwts.builder().setSubject(user.getUserId()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS384, SECRET_KEY).compact();
		Map<String, String> map = new HashMap<>();
		map.put("token", token);
		map.put("message", "Login is successful!");
		return map;
	}
}

package com.travel_tales.voyage_engine.util;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private final int TOKEN_VALIDITY = 3600 * 1000;

	private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	public String generateToken(String username) {

		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY)).signWith(key).compact();
	}

	public String extractUsername(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token, UserDetails userdetails) {

		final String username = extractUsername(token);
		return username.equals(userdetails.getUsername()) && !isTokenExpired(token);

	}

	private boolean isTokenExpired(String token) {
		Date expiration = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getExpiration();
		return expiration.before(new Date());
	}

}

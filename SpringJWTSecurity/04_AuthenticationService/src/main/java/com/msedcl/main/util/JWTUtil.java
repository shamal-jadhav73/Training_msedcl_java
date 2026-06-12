package com.msedcl.main.util;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JWTUtil {
	
	// This is your secret password for signing JWT
	private final String SECRET="msedcl-secret-msedcl-secret-msedcl-secret";
	
	//CONVERTS YOUR STRING SECRET-> INTO CRYPTOGRAPHIC KEY
	//USING HMAC-SHA ALGORITHM WHICH IS ALSO KNOWN AS (H256)
	public Key getSignKey()
	{
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}
	
	public String generateToken(String userName)
	{
		return Jwts.builder()
				.setSubject(userName)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+36_00_000))
				.signWith(getSignKey())
				.compact();
	}
	
	//step1:Parse token
	//step 2: Verify the signature
	//Step 3: Check Expiry
	//Step 4: Return Claims
	private Claims getClaims(String token)
	{
		return Jwts.parserBuilder()
				.setSigningKey(getSignKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	
	public String extractUserName(String token)
	{
		return getClaims(token).getSubject();
	}
}

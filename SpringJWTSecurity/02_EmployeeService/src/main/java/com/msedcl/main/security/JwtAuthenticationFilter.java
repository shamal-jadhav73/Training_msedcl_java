package com.msedcl.main.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	private final JWTUtil jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//load the bearer token from header
		String authHeader=request.getHeader("Authorization");
		
		if(authHeader!=null && authHeader.startsWith("Bearer "))
		{
			//Extraction =>Extract token and remove "Bearer " string from header
			String token=authHeader.substring(7);
			
			//CLAIM TOKEN
			String userName=jwtUtil.extractUserName(token);
			
			//till this poiny myJWT token authentication done only
			
			//setting for spring Authentication
			//Letting spring know that user is already authenticated byJWT token
			UsernamePasswordAuthenticationToken authenticatedUser=new UsernamePasswordAuthenticationToken(userName, null,new ArrayList<>());
			
			//tells spring that this user is authenticated
			SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
			
			//continue request
			filterChain.doFilter(request, response);
		
		
		
		}
		
	}

}

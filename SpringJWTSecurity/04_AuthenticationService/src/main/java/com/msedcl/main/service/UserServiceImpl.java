package com.msedcl.main.service;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.User;
import com.msedcl.main.repository.UserRepository;
import com.msedcl.main.util.JWTUtil;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final JWTUtil jwtUtil;
	


	@Override
	public String validate(String userName, String password) {
		
		boolean result= userRepository.findByUserNameAndPassword(userName, password).isPresent();
	
		if(result)
			return jwtUtil.generateToken(userName);
		else
			return "Invalid Username Or Password";
	
	
	}

	

	

}

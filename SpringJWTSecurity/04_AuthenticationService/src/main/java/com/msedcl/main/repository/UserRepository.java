package com.msedcl.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msedcl.main.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	 Optional<User> findByUserNameAndPassword(String userName,String password);
}

package com.example.springbackend.service;

import com.example.springbackend.domain.entity.User;
import com.example.springbackend.domain.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UsersRepository usersRepository;

	public ResponseEntity<String> register(User user){
		if (usersRepository.existsByUsername(user.getUsername())) {
			return new ResponseEntity<>("Username alredy exists!", HttpStatus.CONFLICT);
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		usersRepository.save(user);
		return new ResponseEntity<>("Registration Successful!", HttpStatus.OK);
	}
}

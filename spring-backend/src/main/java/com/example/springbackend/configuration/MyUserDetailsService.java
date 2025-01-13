package com.example.springbackend.configuration;

import com.example.springbackend.domain.entity.User;
import com.example.springbackend.domain.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = usersRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User " + username + " not found.");
		}
		return new MyUserPrincipal(user);
	}
}

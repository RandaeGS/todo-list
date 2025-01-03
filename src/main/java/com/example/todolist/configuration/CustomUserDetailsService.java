package com.example.todolist.configuration;

import com.example.todolist.domain.entity.AppUser;
import com.example.todolist.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = userRepository.findByUsername(username);
		if (appUser == null) {
			throw new UsernameNotFoundException("AppUser not found");
		}

		return new UserPrincipal(appUser);
	}
}
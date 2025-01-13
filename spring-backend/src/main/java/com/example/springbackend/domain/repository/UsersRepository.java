package com.example.springbackend.domain.repository;

import com.example.springbackend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}

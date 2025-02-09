package com.example.springbackend.domain.repository;

import com.example.springbackend.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findAllByUser_UsernameAndDeletedIsFalse(String username);
	List<Task> findAllByUser_UsernameAndDeletedIsFalseAndCompleted(String user_username, boolean completed);
	Optional<Task> findByDescriptionAndDeletedIsFalseAndUser_Username(String description, String username);
}

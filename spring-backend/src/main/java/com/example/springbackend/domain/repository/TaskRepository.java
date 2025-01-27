package com.example.springbackend.domain.repository;

import com.example.springbackend.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findAllByUser_IdAndDeletedIsFalse(Long userId);
	List<Task> findAllByUser_IdAndDeletedIsFalseAndCompleted(Long user_id, boolean completed);
}

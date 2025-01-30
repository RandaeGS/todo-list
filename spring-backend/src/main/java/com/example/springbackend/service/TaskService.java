package com.example.springbackend.service;

import com.example.springbackend.domain.entity.Task;
import com.example.springbackend.domain.entity.User;
import com.example.springbackend.domain.repository.TaskRepository;
import com.example.springbackend.domain.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
	private final TaskRepository taskRepository;
	private final UsersRepository usersRepository;

	public TaskService(TaskRepository taskRepository, UsersRepository usersRepository) {
		this.taskRepository = taskRepository;
		this.usersRepository = usersRepository;
	}

	public ResponseEntity<String> createTask(Task task, String username) {
		Optional<Task> optionalTask = taskRepository.findByDescriptionAndDeletedIsFalseAndUser_Username(task.getDescription(), username);
		if (optionalTask.isPresent()) {
			return new ResponseEntity<>("Task alredy exists!", HttpStatus.CONFLICT);
		}
		task.setUser(usersRepository.findByUsername(username));
		taskRepository.save(task);
		System.out.println(username + " " +task.getDescription() + " " + task.getUser().getUsername());
		return new ResponseEntity<>("Task saved succesfully!", HttpStatus.OK);
	}

	public List<Task> getUserTasks(String username) {
		return taskRepository.findAllByUser_UsernameAndDeletedIsFalse(username);
	}
}

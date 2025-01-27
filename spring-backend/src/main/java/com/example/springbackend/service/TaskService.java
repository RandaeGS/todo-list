package com.example.springbackend.service;

import com.example.springbackend.domain.entity.Task;
import com.example.springbackend.domain.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public ResponseEntity<String> createTask(Task task) {
		Optional<Task> optionalTask = taskRepository.findByDescriptionAndDeletedIsFalse(task.getDescription());
		if (optionalTask.isPresent()) {
			return new ResponseEntity<>("Task alredy exists!", HttpStatus.CONFLICT);
		}
		taskRepository.save(task);
		return new ResponseEntity<>("Task saved succesfully!", HttpStatus.OK);
	}
}

package com.example.springbackend.controller;

import com.example.springbackend.domain.entity.Task;
import com.example.springbackend.domain.repository.TaskRepository;
import com.example.springbackend.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	public ResponseEntity<String> createTask(@RequestBody Task task){
		return taskService.createTask(task);
	}
}

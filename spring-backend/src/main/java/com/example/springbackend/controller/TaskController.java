package com.example.springbackend.controller;

import com.example.springbackend.domain.entity.Task;
import com.example.springbackend.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@PostMapping
	public ResponseEntity<String> createTask(@RequestBody Task task, Authentication authentication){
		return taskService.createTask(task, authentication.getName());
	}

	@GetMapping
	public List<Task> getUserTasks(Authentication authentication, @RequestParam(required = false) String filter){
		return taskService.getUserTasks(authentication.getName(), filter);
	}

	@PostMapping("/toggle/{id}")
	public ResponseEntity<Boolean> toggleTaskStatus(@PathVariable("id") Long taskid){
		return taskService.toggleTaskStatus(taskid);
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteTask(@PathVariable("id") Long taskId){
		return taskService.deleteTask(taskId);
	}
}

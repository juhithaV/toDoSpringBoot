package com.first.firstProject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.firstProject.models.Task;
import com.first.firstProject.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping
	public List getTasks() {
		List<Task> tasks = taskService.getAllTasks();
		return tasks;
	}
	
	@PostMapping
	public String createTask(@RequestBody Task task) {
		taskService.createTask(task);
		return "Completed";
	}
	
	@GetMapping("/{id}/update")
	public String createTask(@PathVariable Long id) {
		taskService.updateTask(id);
		return "Updated";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return "Deleted";
	}
	
	
	

}

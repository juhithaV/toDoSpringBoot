package com.first.firstProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.first.firstProject.models.Task;
import com.first.firstProject.repository.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	public void createTask(Task task) {
		taskRepository.save(task);
	}
	public void updateTask(long id) {
		Task task = taskRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid"));
		task.setCompleted(!task.isCompleted());
		taskRepository.save(task);
	}
	public void deleteTask(long id) {
		taskRepository.deleteById(id);
	}

}

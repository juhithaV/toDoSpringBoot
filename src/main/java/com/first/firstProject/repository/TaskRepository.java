package com.first.firstProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.firstProject.models.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

}

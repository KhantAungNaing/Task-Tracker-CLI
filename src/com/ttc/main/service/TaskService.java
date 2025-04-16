package com.ttc.main.service;

import java.util.List;

import com.ttc.main.data.Task;

public interface TaskService {

	void createTask(Task task);

	void updateTask(int id, Task task);

	void deleteTask(int id);

	List<Task> listTask();

	List<Task> listTask(String status);

}

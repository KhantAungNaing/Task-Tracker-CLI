package com.ttc.main.service.impl;

import java.util.List;

import com.ttc.main.data.Task;
import com.ttc.main.service.TaskService;
import com.ttc.main.util.JsonHelper;

public class TaskServiceImpl implements TaskService{
	
	public TaskServiceImpl(String fileName) {
		JsonHelper.createJsonFile(fileName);
	}

	@Override
	public void createTask(Task task) {
		
	}

	@Override
	public void updateTask(int id, Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTask(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Task> listTask() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> listTask(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}

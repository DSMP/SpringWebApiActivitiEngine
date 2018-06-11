package com.javasampleapproach.activiti.messageevent.service;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyService {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	public String startProcess(String assignee) {

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("person", assignee);
		runtimeService.startProcessInstanceByKey("NBP_PROCESS");

		return "Process started";
	}
	
	public List<Task> getTasks() {
		return taskService.createTaskQuery().list();
	}

	public void completeTask(String taskId) {
		List<Task> tasks = taskService.createTaskQuery().list();
		Task task = null;
		for (Task item: tasks) {
			if (item.getId().equals(taskId))
				task = item;
		}
		System.out.println(task);
		taskService.complete(taskId);
	}

}
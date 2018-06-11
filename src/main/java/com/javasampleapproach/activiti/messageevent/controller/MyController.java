package com.javasampleapproach.activiti.messageevent.controller;

import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.activiti.messageevent.service.MyService;

@RestController
public class MyController {

	@Autowired
	private MyService myService;

	@RequestMapping(value = "/startprocess/{assignee}")
	public String startProcessInstance(@RequestParam String assignee) {
		return myService.startProcess(assignee);
	}

	@RequestMapping(value = "/tasks/")
	public String getTasks() {
		List<Task> tasks = myService.getTasks();
		return tasks.toString();
	}

	@RequestMapping(value = "/completetask")
	public String completeTask(@RequestParam String id) {
		myService.completeTask(id);
		return "Task with id " + id + " has been completed!";
	}

}

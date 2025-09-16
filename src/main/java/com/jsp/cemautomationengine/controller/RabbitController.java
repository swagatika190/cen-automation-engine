package com.jsp.cemautomationengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.cemautomationengine.service.RabbitMqServiceImpl;

@RestController
public class RabbitController {
	@Autowired
	RabbitMqServiceImpl rabbitserviceimpl;
	
	@PostMapping("/message/{msg}")
	public void sendmsgtoqueue(@PathVariable("msg") String str) {
		 rabbitserviceimpl.sendMessage(str);
	}
}

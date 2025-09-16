package com.jsp.cemautomationengine.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.cemautomationengine.config.RabbitMQConfig;

@Service
public class RabbitMqServiceImpl {
	@Autowired
	RabbitTemplate rabbitTemplete;
	
	
	public void sendMessage(String str) {
		//str.setExecutionStatus("Processing");
		rabbitTemplete.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY,str );
	System.out.println("Workflow Sent to the queue"+str);
		
	}
}

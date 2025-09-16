package com.jsp.cemautomationengine.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.jsp.cemautomationengine.config.RabbitMQConfig;

@Service
public class RabbitmqListener {
  
	@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
	public void consumer(String msg) {
		System.out.println(msg);
		
	}
  
}


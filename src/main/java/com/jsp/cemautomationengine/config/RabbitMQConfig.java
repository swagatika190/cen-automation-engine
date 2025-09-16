package com.jsp.cemautomationengine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

@Configuration
public class RabbitMQConfig {
 public static final String QUEUE_NAME="PracticeQueue";
 public static final String EXCHANGE_NAME="RabbitExchange";
 public static final String ROUTING_KEY="RoutingKey";
 
   @Bean
	public Queue queue() {
		 return new Queue(QUEUE_NAME);
	}
   
   @Bean
   public TopicExchange exchange() {
	   return new TopicExchange(EXCHANGE_NAME);   
   }
   
   @Bean
   public Binding binding(Queue queue,TopicExchange exchange) {
	 return  BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
   }
}

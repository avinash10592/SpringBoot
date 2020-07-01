package com.example;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.config.RabbitMQConfiguration;
import com.example.model.Product;


@SpringBootApplication
public class SpringBootJmsProducerApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) throws InterruptedException
	{
		SpringApplication.run(SpringBootJmsProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		Product product = new Product();
		product.setProductId(100);
		product.setName("Laptop");
		product.setQuantity(10);
		
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicExchangeName,
				"message_routing_key", product);
		System.out.println("Message sent successfully...");
	}

}
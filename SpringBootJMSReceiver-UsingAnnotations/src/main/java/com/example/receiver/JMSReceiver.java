package com.example.receiver;

import org.springframework.stereotype.Component;

import com.example.model.Product;

@Component
public class JMSReceiver {
	public void receiveMessage(Product Product) {
		System.out.println("Received <" + Product + ">");
	}
}

package com.example;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskSchedular {

	//@Scheduled(fixedDelay = 10000)
	@Scheduled(cron = " */10 * * * * * ")
	public void taskScheduling() {
		System.out.println("Welocme to Task Scheduling" + new java.util.Date());
	}
}

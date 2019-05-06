package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class ProducerApp implements CommandLineRunner {

	@Autowired
	private JmsTemplate template;
	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			System.out.println("logger:"+i);
			template.convertAndSend("helloworldactivemq","mesage"+i);
		}
	}
	
	public static void  main(String args[]) {
		SpringApplication.run(ProducerApp.class, args);
	}

}

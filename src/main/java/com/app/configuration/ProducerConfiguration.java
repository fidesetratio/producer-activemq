package com.app.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class ProducerConfiguration {
	

	String BROKER_URL = "tcp://localhost:61616"; 
	String BROKER_USERNAME = "admin"; 
	String BROKER_PASSWORD = "admin";
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
	    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	    connectionFactory.setBrokerURL(BROKER_URL);
		/*
		 * connectionFactory.setPassword(BROKER_USERNAME);
		 * connectionFactory.setUserName(BROKER_PASSWORD);
		 */  return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate(){
	    JmsTemplate template = new JmsTemplate();
	    template.setConnectionFactory(connectionFactory());
	    return template;
	}

	
	
}

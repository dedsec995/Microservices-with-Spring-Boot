package com.dedsec995.M3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.dedsec995.M3.model.User;
import com.dedsec995.M3.repository.UserRepository;

@RestController
@Service
public class Consumer {
	
	@Autowired
	private UserRepository repository;
		
	@KafkaListener(topics="k2-topic",groupId="mygroup")
	public void consumerFromtopic(String message) {
		System.out.println("consumer" + message);
		
	    int len=message.length();
		User users=new User(message.substring(0, 17),message.substring(17,18),message.substring(18, len-1),message.substring(len-1));
		repository.save(users);
		System.out.println("Done Writing");
		
	}
}
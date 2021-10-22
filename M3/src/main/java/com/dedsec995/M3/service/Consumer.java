package com.dedsec995.M3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

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
		Date date = new Date();
   		Timestamp ts=new Timestamp(date.getTime());
		int len=message.length();
		int speed = Integer.parseInt(message.substring(18, len-1));
		User users=new User(message.substring(0, 17),message.substring(17,18),speed,message.substring(len-1),ts);
		repository.save(users);
		System.out.println("Done Writing");
		
	}
}
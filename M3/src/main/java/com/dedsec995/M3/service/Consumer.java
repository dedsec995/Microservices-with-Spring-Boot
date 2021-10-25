package com.dedsec995.M3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

import com.dedsec995.M3.model.User;
import com.dedsec995.M3.repository.UserRepository;

@RestController
@Service
public class Consumer {
	
	@Autowired
	private UserRepository repository;
		
	@KafkaListener(topics="k2-topic",groupId="mygroup")
	public void consumerFromtopic(String message) throws ParseException {
		System.out.println("consumer" + message);
		String msg = message.substring(22);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse(msg);
        long time = date.getTime();

        Timestamp ts = new Timestamp(time);
		int speed = Integer.parseInt(message.substring(18, 21));
		User users=new User(message.substring(0, 17),message.substring(17,18),speed,message.substring(21, 22),ts);
		repository.save(users);
		System.out.println("Done Writing");
		
	}
}
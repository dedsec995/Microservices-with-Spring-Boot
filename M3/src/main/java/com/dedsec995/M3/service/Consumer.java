package com.dedsec995.M3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

import com.datastax.oss.driver.api.core.servererrors.InvalidQueryException;
import com.dedsec995.M3.model.User;
import com.dedsec995.M3.repository.UserRepository;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RestController
@Service
public class Consumer {
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private EmailSenderService service;
		
	@KafkaListener(topics="k2-topic",groupId="mygroup")
	public void consumerFromtopic(String message) throws ParseException {
		System.out.println("consumer" + message);
		String msg = message.substring(22);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse(msg);
        long time = date.getTime();

        Timestamp ts = new Timestamp(time);
		int speed = Integer.parseInt(message.substring(18, 21));
		// User users=new User(message.substring(0, 17),message.substring(17,18),speed,message.substring(21, 22),ts);
		// repository.save(users);
		System.out.println("Done Writing");
		
		String s1=message.substring(21, 22);
		String s2="y";
		
		try {
		User users = new User(message.substring(0, 17),message.substring(17,18),speed,message.substring(21, 22),ts);
		repository.save(users);
		System.out.println("Done Writing");
		
		
		if(s1.equals(s2)) {
		
		// this.service.sendSimpleEmail("itachu.uchiha@gmail.com","Warning! you have crossed the speed limit",message.substring(0,17),speed,ts);
		}
		
		}
		catch (InvalidQueryException e) {
			System.out.println("Exception 1");
		}
		catch (DataAccessException ex) {
			System.out.println("Exception Occured mail not sent!!!");
		}


		
	}
}

@Service
class EmailSenderService 
{
	@Autowired
	private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail,String subject,String body, int sped, Timestamp ts) 
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sunilindi0@gmail");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText("VIN:- "+body+" \nYour Speed is:- "+sped+" at Time :- "+ts);
        mailSender.send(message);
        System.out.println("Mail Sent...");
    }
		
}

package com.dedsec995.M3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

import com.datastax.oss.driver.api.core.servererrors.InvalidQueryException;
import com.dedsec995.M3.model.User;
import com.dedsec995.M3.repository.UserRepository;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@RestController
@Service
public class Consumer {
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private EmailSenderService emailSenderService;
	
		
	@KafkaListener(topics="k2-topic",groupId="mygroup")
	public void consumerFromtopic(String message) throws Exception {
		System.out.println("consumer" + message);
		String msg = message.substring(22);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse(msg);
        long time = date.getTime();
		String[] emailIds = new String[3];
		emailIds[0] = "beyouabde@gmail.com";
		emailIds[1] = "sunilindi@tataelxsi.co.in";
		emailIds[2] = "sunilindi0@gmail.com";

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
		
		
		if(s1.equals(s2) && message.substring(17,18).equals(s2)) {

	
		
			this.emailSenderService.sendHTML(emailIds,"sunilindi0@gamil.com", "Warning!! You have Crossed the Speed", "<h2>ALERT...!!!<h2>"+"<p>Dear user you have crossed the speed limits, your vehicle is running with overspeed <br/>The Safe Speed limit was 100 km/h.<p>"+"<h2>Details: </h2>"+"<h2>Your Vin:"+message.substring(0, 17)+" </h2>"+"<h2>Speed:"+speed+" km/h</h2>"+"<h2>Date and Time:"+ts+" </h2>");
			System.out.println("mail sent....");
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
	private JavaMailSender javaMailSender;


	public void sendHTML(String[] toAddress, String fromAddress, String subject, String content) throws Exception {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setFrom(fromAddress);
		mimeMessageHelper.setTo(toAddress);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(content,true);
		javaMailSender.send(mimeMessage);
		
	}
	
}
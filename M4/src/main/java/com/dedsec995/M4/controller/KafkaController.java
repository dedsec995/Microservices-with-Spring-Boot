package com.dedsec995.M4.controller;


import java.util.*;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.rmi.ServerException;
import java.sql.Timestamp;
import java.text.*;

import javax.annotation.PostConstruct;
// import javax.mail.MessagingException;

// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Service;

import com.datastax.oss.driver.*;
import com.datastax.oss.driver.api.core.NoNodeAvailableException;
import com.datastax.oss.driver.api.core.servererrors.InvalidQueryException;
import com.datastax.oss.driver.api.core.servererrors.ServerError;
import com.datastax.oss.driver.api.core.servererrors.UnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerErrorException;

import com.dedsec995.M4.model.*;
import com.dedsec995.M4.repository.*;

@RestController
@RequestMapping("/my")
public class KafkaController {

	
	@Autowired
	private UserRepository repository;
	
//	@Autowired
//	private EmailSenderService service;
    
    String message = "4VJDXMRYWCB164486Y100Y2021-10-24 20:15:10";
    int len=message.length();
    String msgdt = message.substring(22,len);
    int sp = Integer.parseInt(message.substring(18, 21));
    String nl = "";
    String flg = "Y";
    
    
//    @PostConstruct
//    public void call() throws ParseException
//    {
//    	for(int i =0; i<30; i++)
//    	{
//    		sp += 5;
//    		saveUser();
//    	}
//    	
//    }
	
    @PostConstruct
	public void saveUser() throws ParseException, Exception{

//		  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = df.parse(msgdt);
//        long time = date.getTime();
//        Timestamp ts = new Timestamp(time);
	    
		//Test1 users=new Test1(message.substring(0,17),message.substring(17,18),sp,message.substring(21,22),ts);
        
    	 Date date= new Date();
    	 long time = date.getTime();
    	 Timestamp ts = new Timestamp(time);
    	
		List<User> users = new ArrayList<>();
		users.add(new User("4VJDXMRYWCB164486","Y",105,"Y",ts));
		users.add(new User("6DADXMRYWCB635214","Y",124,"Y",ts));
		users.add(new User("7HYDXMRYWCB876325","Y",160,"Y",ts));
		users.add(new User("6DADXMRYWCB987452","Y",207,"Y",ts));
		
		
		try {
			//repository.save(new Test1(message.substring(0,17),message.substring(17,18),sp,message.substring(21,22),ts));
			//repository.saveAll(users);
			//repository.save(new Test1(nl,message.substring(17,18),200,message.substring(21,22),ts));
			//System.out.println("Exception Not Occured :):):)");
			//this.service.sendSimpleEmail("springtesttbu@gmail.com","Warning! you have crossed the speed limit",message.substring(0,17),sp,ts);
			
			
			
			
			//Multi-Threading part--------->>>
			
//			try {
//				new Thread(new Runnable() {
//				     @Override
//				     public void run() {
//				    	 service.sendSimpleEmail("springtesttbu@gmail.com","Warning! you have crossed the speed limit",message.substring(0,17),sp,ts);
//				     }
//				}).start();
//				Thread.sleep(500);
//			} catch (Exception e) {
//				System.out.println("Thread not Created!!!");
//			}

//			Executors.newCachedThreadPool().execute(new Runnable() {			
//			    @Override
//			    public void run() {
//		            try {
//		            	service.sendSimpleEmail("springtesttbu@gmail.com","Warning! you have crossed the speed limit",message.substring(0,17),sp,ts);
//		            	//System.out.println(Thread.activeCount());
//		            }
//		            catch (Exception e) {
//		                System.out.println("Thread not Created!!!");
//		            }
//		            
//			    }
//			});
//			Thread.sleep(300);
			
			
		} 
		catch (InvalidQueryException e) {
			System.out.println("Exception 1");
		}
		catch (DataAccessException ex) {
			System.out.println("Exception Occured mail not sent!!!");
		}
		
	}	
	
	
//	CREATE TABLE Test1 (
//			vin text,
//			verify text,
//			speed int,
//			alert text,
//			timest timestamp,
//		    PRIMARY KEY (vin,timest)
//		);
	

//    Fetching Data from Database------------------>>>>>>
    
//    Fetching All User Data----------------------->
	@GetMapping("/getAllUsers")
	public List<User> getUsers() {
		
		List<User> data = repository.findAll();		
		Collections.sort(data);
		
		for(User datas: data)
		{
			System.out.println(datas);
		}
		
		return data;
	}
	
	
//  Fetching User Data by VIN----------------------->	
	@GetMapping("/getUsersbyVin/{vin}")
	public List<User> getUsersbyvin(@PathVariable String vin) {
		
		List<User> data = repository.findByvin(vin);
		Collections.sort(data);	
		
		for(User datas: data)
		{
			System.out.println(datas);
		}
		return data;
	}
	
//  Fetching User Data Greater than Speed----------------------->	
	@GetMapping("/getUsersbySpeed/{speed}")
	public List<User> getUsersbySpeed(@PathVariable int speed) {
		
		List<User> data = repository.findBySpeedGreaterThan(speed);
		Collections.sort(data);	
		
		for(User datas: data)
		{
			System.out.println(datas);
		}
		
		return data;
	}	
	
	
//  Fetching User Data for Alert Message----------------------->	
	@GetMapping("/getUsersbyAlert/{alert}")
	public List<User> getUsersbyAlert(@PathVariable String alert) {
		
		List<User> data = repository.findbyAlert(alert);
		Collections.sort(data);	
		
		for(User datas: data)
		{
			System.out.println(datas);
		}
		
		return data;
	}	
	
//  Fetching User Data for Verify Message----------------------->	
	@GetMapping("/getUsersbyVerify/{verify}")
	public List<User> getUsersbyVerify(@PathVariable String verify) {
		
		List<User> data = repository.findbyVerify(verify);
		Collections.sort(data);	
		
		for(User datas: data)
		{
			System.out.println(datas);
		}
		
		return data;
	}
		
//  Fetching User Data for Verify Message----------------------->	
	@GetMapping("/getUsersbyTime/{timest}")
	public List<User> getUsersbyTime(@PathVariable Timestamp timest) {
		
		List<User> data = repository.findbyTimeStamp(timest);
		Collections.sort(data);	
		
		for(User datas: data)
		{
			System.out.println(datas);
		}
		
		return data;
	}			
		
	
	
	
}


//@Service
//class EmailSenderService 
//{
//	@Autowired
//	private JavaMailSender mailSender;
//
//    public void sendSimpleEmail(String toEmail,String subject,String body, int sped, Timestamp ts) 
//    {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("springtesttbu@gmail");
//        message.setTo(toEmail);
//        message.setSubject(subject);
//        message.setText("VIN:- "+body+" \nYour Speed is:- "+sped+" at Time :- "+ts);
//        mailSender.send(message);
//        System.out.println("Mail Sent...");
//    }
//		
//}

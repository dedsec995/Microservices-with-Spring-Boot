package com.dedsec995.M4.controller;


import java.sql.Timestamp;
import java.util.*;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dedsec995.M4.model.*;
import com.dedsec995.M4.repository.*;

@RestController
@RequestMapping("/my")
public class KafkaController {

	
	@Autowired
	private UserRepository repository;

    
    

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



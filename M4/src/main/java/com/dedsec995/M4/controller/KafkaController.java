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
	
//  Fetching User Data for Verified Message----------------------->	
	@GetMapping("/getUsersbyVerified/{verified}")
	public List<User> getUsersbyVerified(@PathVariable String verified) {
		
		List<User> data = repository.findbyVerified(verified);
		Collections.sort(data);	
		
		for(User datas: data)
		{
			System.out.println(datas);
		}
		
		return data;
	}
		
//  Fetching User Data for Verified Message----------------------->	
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


	//  Fetching User Data between Speed Range----------------------->   
    @GetMapping("/getbySpeedbetween/{speed}/{speed2}")
    public List<User> findBySpeedBetween(@PathVariable int speed, @PathVariable int speed2) {

        List<User> data = repository.findBySpeedBetween(speed,speed2);
        Collections.sort(data);   

        for(User datas: data)
        {
            System.out.println(datas);
        }

        return data;
    }
		
	
	
	
}



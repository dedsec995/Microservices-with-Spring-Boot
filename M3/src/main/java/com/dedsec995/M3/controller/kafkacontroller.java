package com.dedsec995.M3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import com.dedsec995.M3.service.Pro;
import com.dedsec995.M3.repository.UserRepository;
import com.dedsec995.M3.model.User;
import java.util.*;

@RestController
@RequestMapping("/my")
public class kafkacontroller {
	
	@Autowired
	Pro pro;

	@Autowired
	private UserRepository repository;
	
	@PostMapping(value="/post")
	public void sendMessage(@RequestParam("msg") String msg) {
		pro.publishToTopic(msg);
	}
	@GetMapping("/getAllUsers")
    public List<User> getUsers() {
        return repository.findAll();
    }
	@PostMapping("/test")
    public void postBody(@RequestBody String fullName) {
        System.out.println(fullName); 
    }
}
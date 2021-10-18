package com.dedsec995.M3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dedsec995.M3.service.Pro;

@RestController
@RequestMapping("/my")
public class kafkacontroller {
	
	@Autowired
	Pro pro;
	
	@PostMapping(value="/post")
	public void sendMessage(@RequestParam("msg") String msg) {
		pro.publishToTopic(msg);
	}
}

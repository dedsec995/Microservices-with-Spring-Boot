package com.dedsec995.M1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dedsec995.M1.RandomString;
import com.dedsec995.M1.service.Producer;



@RestController
@CrossOrigin
@RequestMapping("/my")
public class KafkaController {
	
	@Autowired 
	Producer producer;


	@PostMapping(value="/pro")
    public void postBody(@RequestParam("vin") int vin,@RequestParam("freq") int freq) {
        // System.out.println(vin);
        // System.out.println(freq);
        int secondsToSleep = freq;
	    int i;
		try{
			for(i=0;i<vin;i++){
			String result1 = RandomString.getVinSpeed(20);
			producer.publishToTopic(result1);
			Thread.sleep(secondsToSleep * 1000);
			}
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
    }
}

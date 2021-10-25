package com.dedsec995.M1.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


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
    public void postBody(@RequestParam("vin") int vin,@RequestParam("freq") int freq,@RequestParam("same")Optional<String> same) {
        // System.out.println(vin);
        // System.out.println(freq);
        int secondsToSleep = freq;
	    int i;
		boolean isEqual = same.isPresent() && same.get().equals("y");
		if(same.isEmpty()){
			try{
				for(i=0;i<vin;i++){
				String result1 = RandomString.getVinSpeed(20);
				Date date=new Date();
				Timestamp ts=new Timestamp(date.getTime());
				DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String strDate=dateFormat.format(ts);
					
				producer.publishToTopic(result1+strDate);	
				Thread.sleep(secondsToSleep * 1000);
				}
			}catch(InterruptedException ie){
				Thread.currentThread().interrupt();
			}
		}
		else if(isEqual){
			String vinn = RandomString.getVin();
			try{
				for(i=0;i<vin;i++){
					Date date=new Date();
					Timestamp ts=new Timestamp(date.getTime());
					DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String strDate=dateFormat.format(ts);	
					String speeed = RandomString.getSpeed();
					producer.publishToTopic(vinn+speeed+strDate);
					Thread.sleep(secondsToSleep * 1000);
				}
			}catch(InterruptedException ie){
				Thread.currentThread().interrupt();
			}
		}
		else{
			try{
				for(i=0;i<vin;i++){
					String result1 = RandomString.getVinSpeed(20);
					Date date=new Date();
					Timestamp ts=new Timestamp(date.getTime());
					DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String strDate=dateFormat.format(ts);
						
					producer.publishToTopic(result1+strDate);
					Thread.sleep(secondsToSleep * 1000);
				}
			}catch(InterruptedException ie){
				Thread.currentThread().interrupt();
			}
		}
    }
}

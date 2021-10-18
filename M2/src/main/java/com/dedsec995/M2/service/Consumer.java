package com.dedsec995.M2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	@Autowired 
	Producer producer;
	
	@KafkaListener(topics="k1-topic", groupId="mygroup")
	public int consumeFromTopic(String message) {

        System.out.println("Consummed message "+message);

        if(message.length() != 20) {
	    	return 0;
	    }
	    
	    String vin = message.substring(0,17);
 	    String speed = message.substring(17,20);
 	    boolean isalphaNumeric;
 	    boolean isNumeric;
        char verify = 'n';
        char alert = 'n';
 	    isalphaNumeric = vin.matches("^[a-zA-Z0-9]*$");
 	    isNumeric = speed.matches("^[0-9]*$");
 	   
 	   if(isalphaNumeric && isNumeric) {
            if(Integer.parseInt(speed)>100){
                alert = 'y';
                verify = 'y';
                producer.publishToTopic(vin+verify+speed+alert);
            }
            else{
                verify = 'y';
                producer.publishToTopic(vin+verify+speed+alert);
            }
 		  return 1;
 	   }
		else{
			if(Integer.parseInt(speed)>100){
                alert = 'y';
                verify = 'n';
                producer.publishToTopic(vin+verify+speed+alert);
            }
			else{
                verify = 'n';
				alert ='n';
                producer.publishToTopic(vin+verify+speed+alert);
            }
		}
		return 0;
		
		//String sample = "a1sderfghju147896325";
	    //String [] splitString = sample.split();
			
		
		
	}
}
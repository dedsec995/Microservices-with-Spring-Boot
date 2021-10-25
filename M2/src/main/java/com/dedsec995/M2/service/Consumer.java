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

        String msg=message.substring(0, 20);
        String dateTime=message.substring(20);

        if(msg.length() != 20) {
	    	return 0;
	    }
	    
	    String vin = msg.substring(0,17);
 	    String speed = msg.substring(17,20);
 	    boolean isvinaalphaNumeric;
        boolean isvinnNumeric;
 	    boolean isNumeric;
        char verify = 'n';
        char alert = 'n';
		String vina = vin.substring(0,10);
        String vinn = vin.substring(11,16);
		isvinaalphaNumeric = vina.matches("^[a-zA-Z0-9]*$");
        isvinnNumeric = vinn.matches("^[0-9]*$");
        isNumeric = speed.matches("^[0-9]*$");
 	   
 	   if(isvinaalphaNumeric && isNumeric && isvinnNumeric) {
            if(Integer.parseInt(speed)>100){
                alert = 'y';
                verify = 'y';
                producer.publishToTopic(vin+verify+speed+alert+dateTime);
            }
            else{
                verify = 'y';
                producer.publishToTopic(vin+verify+speed+alert+dateTime);
            }
 		  return 1;
 	   }
		else{
			if(Integer.parseInt(speed)>100){
                alert = 'y';
                verify = 'n';
                producer.publishToTopic(vin+verify+speed+alert+dateTime);
            }
			else{
                verify = 'n';
				alert ='n';
                producer.publishToTopic(vin+verify+speed+alert+dateTime);
            }
		}
		return 0;
		
		//String sample = "a1sderfghju147896325";
	    //String [] splitString = sample.split();
			
		
		
	}
}
package com.dedsec995.M2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dedsec995.M2.service.Producer;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@CrossOrigin
@RequestMapping("/my")
public class kafkaController {
	
	@Autowired 
	Producer producer;

	
	@PostMapping(value="/post")
	public void sendMessage(@RequestParam("msg") String msg) {
		producer.publishToTopic(msg);
	}
    

	@PostMapping(value="/manual")
    public String postBody(@RequestParam("vin") String vin,@RequestParam("speed") String speed) {
        boolean isvinaalphaNumeric;
        boolean isvinnNumeric;
 	    boolean isNumeric;
        Date date=new Date();
        Timestamp ts=new Timestamp(date.getTime());
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate=dateFormat.format(ts);
        char verify = 'n';
        char alert = 'n';
        int sp=Integer.parseInt(speed);

        if(vin.isEmpty() || speed.isEmpty()){
            return "Data is empty";
        }
        if(vin.length()!=17 || speed.length()!= 3 || sp<0){
            return "Data is not appropriate";
        }
        String vina = vin.substring(0,10);
        String vinn = vin.substring(11,16);

        isvinaalphaNumeric = vina.matches("^[a-zA-Z0-9]*$");
        isvinnNumeric = vinn.matches("^[0-9]*$");
        isNumeric = speed.matches("^[0-9]*$");
 	   
 	   if(isvinaalphaNumeric && isNumeric && isvinnNumeric) {
            if(Integer.parseInt(speed)>100){
                alert = 'y';
                verify = 'y';
                producer.publishToTopic(vin+verify+speed+alert+strDate);
            }
            else{
                verify = 'y';
                producer.publishToTopic(vin+verify+speed+alert+strDate);
            }
 		  return "Data is acceptable";
 	   }
		else{
			if(Integer.parseInt(speed)>100){
                alert = 'y';
                verify = 'n';
                producer.publishToTopic(vin+verify+speed+alert+strDate);
            }
			else{
                verify = 'n';
				alert ='n';
                producer.publishToTopic(vin+verify+speed+alert+strDate);
            }
		}
		return "Data is acceptable";
    }
}

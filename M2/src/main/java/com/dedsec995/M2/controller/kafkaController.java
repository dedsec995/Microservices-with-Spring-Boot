package com.dedsec995.M2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dedsec995.M2.service.Producer;


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
    

	@PostMapping(value="/test")
    public String postBody(@RequestParam("vin") String vin,@RequestParam("speed") String speed) {
        boolean isvinaalphaNumeric;
        boolean isvinnNumeric;
 	    boolean isNumeric;
        char verify = 'n';
        char alert = 'n';
        if(vin.isEmpty() || speed.isEmpty()){
            return "Data is empty";
        }
        if(vin.length()!=17 || speed.length()!= 3){
            return "Data is not of appropriate size";
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
                producer.publishToTopic(vin+verify+speed+alert);
            }
            else{
                verify = 'y';
                producer.publishToTopic(vin+verify+speed+alert);
            }
 		  return "Data is acceptable";
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
		return "Data is acceptable";
    }
}

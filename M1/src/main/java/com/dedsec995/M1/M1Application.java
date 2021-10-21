package com.dedsec995.M1;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.backoff.Sleeper;

import javax.annotation.PostConstruct;

import com.dedsec995.M1.service.Producer;

@SpringBootApplication
public class M1Application {

	@Autowired
	Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(M1Application.class, args);
	}


	@PostConstruct
	public void m1() {



		Scanner sc = new Scanner(System.in);
		System.out.println("How many vin need to be generated: ");
		int input = sc.nextInt();
		for(int a=1; a<=input ; a++) {
		
		int n = 20;
		
		String result1 = RandomString.getVinSpeed(n);
		// Get and display the alphanumeric string
		System.out.println(result1);
		producer.publishToTopic(result1);		
		}
	// int secondsToSleep = 5;
	// System.out.println("How many {VIN,Speed} You want to generate");
	// int input2 = sc.nextInt();
	// int i;
	// 	try{
	// 		for(i=0;i<=input2;i++){
	// 		String result1 = RandomString.getVinSpeed(20);
	// 		producer.publishToTopic(result1);
	// 		Thread.sleep(input * 1000);
	// 		}
	// 	}catch(InterruptedException ie){
	// 		Thread.currentThread().interrupt();
	// 	}
	
		// System.out.println(input + " " + "Random Strings Generated"+", Thank You :)");

		
			
	}

}

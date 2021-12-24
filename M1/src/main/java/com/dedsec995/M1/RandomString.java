package com.dedsec995.M1;

public class RandomString {

    
public static String getVinSpeed(int n)
{

	// chose a Character and Integer random from this String
	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
	String NumericString = "0123456789";

	// create StringBuffer size of AlphaNumericString
	StringBuilder sb = new StringBuilder(n);

	for (int i = 0; i < n; i++) {
			if(i>=0 && i < n-19) {

			int index = (int)(NumericString.length() * Math.random());

			sb.append(NumericString.charAt(index));
		}
			else if(i>=1 && i < n-9) {
				int index = (int)(AlphaNumericString.length() * Math.random());

			sb.append(AlphaNumericString.charAt(index));
		}
			
			else if(i>=11 && i < n-3) {
				int index = (int)(NumericString.length()* Math.random());

		sb.append(NumericString.charAt(index));
		}
			
		else if(i==17) {
			int min = 000;  
			int max = 300;  
			int speed = (int)(Math.random()*(max-min+1)+min);
			
			String result = String.format("%03d", speed);
			
			sb.append(result);
		}
	
	
	
	}
	
	// int strlen = sb.length();
	// System.out.println(strlen);
	
	return sb.toString();
	
		
}

public static String getVin()
{

	// chose a Character and Integer random from this String
	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";

	// create StringBuffer size of AlphaNumericString
	StringBuilder sb = new StringBuilder(17);

	for (int i = 0; i < 17; i++) {
		int index = (int)(AlphaNumericString.length() * Math.random());
		sb.append(AlphaNumericString.charAt(index));
	}
	
	// int strlen = sb.length();
	// System.out.println(strlen);
	
	return sb.toString();
	
		
}
public static String getSpeed()
{

	// String NumericString = "0123456789";
	// StringBuilder sb = new StringBuilder(3);

	// for (int i = 0; i < 3; i++) {
	// 	int index = (int)(NumericString.length() * Math.random());
	// 	sb.append(NumericString.charAt(index));
	// }	
	// // int strlen = sb.length();
	// // System.out.println(strlen);
	int r = (int) (Math.random() * (240 - 1)) + 1;
	
	return Integer.toString(r);
	
		
}
public static String getStepSpeed(String basespeeed)
{

	// String NumericString = "0123456789";
	StringBuilder sb = new StringBuilder(3);
	int basey = Integer.parseInt(basespeeed);

	if (basey > 150) {
		int r = (int) (Math.random() * (9 - 1)) + 1;
		if(Math.random() < 0.5) {
			basey = basey + ((basey * r) / 100);
		}
		else{
			basey = basey - ((basey * r) / 100);
		}
	}
	else{
		int r = (int) (Math.random() * (15 - 1)) + 1;
		if(Math.random() < 0.5) {
			basey = basey + ((basey * r) / 100);
		}
		else{
			basey = basey - ((basey * r) / 100);
		}
	}
	
	
	// int index = (int)(NumericString.length() * Math.random());
	// sb.append(NumericString.charAt(index));

	// int strlen = sb.length();
	// System.out.println(strlen);
	
	return Integer.toString(basey);
	
		
}
}

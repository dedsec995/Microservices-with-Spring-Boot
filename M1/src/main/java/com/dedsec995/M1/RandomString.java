package com.dedsec995.M1;

public class RandomString {

    
static String getVinSpeed(int n)
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
			int max = 999;  
			int speed = (int)(Math.random()*(max-min+1)+min);
			
			String result = String.format("%03d", speed);
			
			sb.append(result);
		}
	
	
	
	}
	
	// int strlen = sb.length();
	// System.out.println(strlen);
	
	return sb.toString();
	
		
}


}

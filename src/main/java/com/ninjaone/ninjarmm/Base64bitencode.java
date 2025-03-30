package com.ninjaone.ninjarmm;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64bitencode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        String originalString = "3GW6F7DS5M7GBYGF";
	        encodeString(originalString);
	        decodeString(originalString);
	        
	}
	     
	public static void encodeString(String str) {

	        // Encoding to Base64
	        String encodedString = Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
	        System.out.println("Encoded string: " + encodedString);

	        
	    }
	
	public static String decodeString(String str) {
		// Decoding from Base64
        byte[] decodedBytes = Base64.getDecoder().decode("M0dXNkY3RFM1TTdHQllHRg==");
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
        System.out.println("Decoded string: " + decodedString);
        return decodedString;
	}

}

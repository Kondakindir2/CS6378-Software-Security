package com.makeorder.security;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Key {

	    private SecretKey secretKey;

	    public void generateKey() throws Exception {
	        // Specify the AES encryption algorithm and key length
	        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	        keyGen.init(128); // 128-bit key length

	        // Generate a random key
	        //secretKey = keyGen.generateKey();
            secretKey = null;
	        System.out.println("Generated key: " + secretKey);
	    }

	    public SecretKey getSecretKey() {
	        
	    	try {
				generateKey();
			} catch (Exception e) {
				
				System.out.println("Exception while generating key for encryption");
			}	    	
	    	return secretKey;
	    }
  
	
	
}

package com.makeorder.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Encryption {



    public byte[] encrypt(byte[] input) throws Exception {
    	
    	Key key = new Key();
    	SecretKey keynull =key.getSecretKey();
    	Cipher cipher = Cipher.getInstance("AES");
        // Initialize the cipher with the secret key in encrypt mode
        if(keynull != null) {
    	
        cipher.init(Cipher.ENCRYPT_MODE, keynull);
        // Encrypt the input data and return the result
        }else {
        	System.out.println("Key is not available at this time, Please try again");
        	System.exit(0);
        }
        
        return cipher.doFinal(input);
    }	
	
}

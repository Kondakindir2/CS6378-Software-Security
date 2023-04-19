package com.makeorder.security;

import java.security.PrivateKey;
import java.security.Signature;

public class DigitalSignatureGenerator {

	 private PrivateKey privateKey;

	    public DigitalSignatureGenerator(PrivateKey privateKey) {
	        this.privateKey = privateKey;
	    }

	    
// In this example, the digital signature is generated using the SHA-256 hash 
//	 function and the RSA public-key cryptosystem. 
//	 The specific hash function and cryptosystem used may vary depending on your application's 
//	 requirements.
	    
	    public byte[] generate(byte[] data) throws Exception {
	        Signature signature = Signature.getInstance("SHA256withRSA");
	        signature.initSign(privateKey);
	        signature.update(data);
	        return signature.sign();
	    }
	
	
}


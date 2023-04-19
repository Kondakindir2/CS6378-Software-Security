package com.makeorder.main;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import com.makeorder.application.CustomerInterface;
import com.makeorder.application.PurchaseOrderManagement;
import com.makeorder.security.CreditCardChecker;
import com.makeorder.security.DigitalSignatureGenerator;
import com.makeorder.security.OrderRequestChecker;
import com.makeorder.vo.OrderRequest;

public class MakeOrderRequest {

	public static void main(String[] args) {
		
		CustomerInterface ci = new CustomerInterface();
		OrderRequest or = ci.createOrderRequest();
		
		OrderRequestChecker oc = new OrderRequestChecker();
		CreditCardChecker cc = new CreditCardChecker();
		boolean isOrderValid = oc.verifyOrderRequest(or);
		boolean isCCValid = cc.verifyCreditCard(or);
		
		//Sign order Request
		// Generate the digital signature for the OrderRequest
		KeyPairGenerator keyPairGen;
		try {
			keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(2048);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();
		DigitalSignatureGenerator signatureGenerator = new DigitalSignatureGenerator(privateKey);
		byte[] signature = signatureGenerator.generate(or.toByteArray());

		// Add the digital signature to the OrderRequest
		or.setSignature(signature);
		
		  if(!isOrderValid) {
	        	System.out.println("Please enter order details again:");
	        	main(args);
	        }
		
		if(isCCValid) {
			System.out.println("Credit card is valid");
		}else {
			System.out.println("Credit card details are not correct , Please enter order details again:");
			main(args);
		}

        
        if(isCCValid && isOrderValid) {
        	
        	PurchaseOrderManagement pm = new PurchaseOrderManagement();
        	String confirmation = pm.processOrder(or,publicKey);
            System.out.println(confirmation);
        }
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}

}

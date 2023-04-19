package com.makeorder.application;

import java.security.PublicKey;

import com.makeorder.security.DigitalSignatureVerifier;
import com.makeorder.vo.OrderRequest;

public class DeliveryOrder {

	public String createOrder(OrderRequest or,PublicKey publicKey) {
		
		DigitalSignatureVerifier verifier = new DigitalSignatureVerifier(publicKey);
		boolean checkSignature = false;
		try {
			
			checkSignature = verifier.verifySignature(or.toByteArray(),or.getSignature());		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	if(!checkSignature) {
		return "User is not verified ,Please recreate order.";
		
	}else {
		
		return "Order is successfully created ! Order Details: Item="+or.getItem()+" Quantity: "+or.getQuantity()+" Price: "+or.getPrice();
	}	
				
	}
	
}

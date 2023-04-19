package com.makeorder.security;

import com.makeorder.vo.OrderRequest;

public class CreditCardChecker {

	public boolean verifyCreditCard(OrderRequest orderRequest) {
        // Check if the credit card number and expiration date are not null or empty
		
		boolean ccCheck = true;
		
        if (orderRequest.getCreditCardNumber() == null || orderRequest.getCreditCardNumber().isEmpty()
                || orderRequest.getExpDate() == null || orderRequest.getExpDate().isEmpty()) {
            return false;
        }

        // Check if the credit card is valid
        boolean isCreditCardValid = validateCreditCard(orderRequest,ccCheck);
        if (!isCreditCardValid) {
            return false;
        }

        // All checks passed, credit card information is valid
        return true;
    }
	
    private boolean validateCreditCard(OrderRequest or, boolean ccCheck) {
         	
    	if(or.getCreditCardNumber() !=null || !or.getCreditCardNumber().isEmpty()) {
    	
    	try {
            int intValue = Integer.parseInt(or.getCreditCardNumber());
                       
        } catch (NumberFormatException e) {
            System.out.println("Credit Card should be numeric");
            ccCheck = false;
        }
    	
    	}else {
    		System.out.println("Credit card cannot be blank");
    	}
    	
    	
    	if(or.getSecuritycode() != null || !or.getSecuritycode().isEmpty()) {
    		try {
                int intValue = Integer.parseInt(or.getSecuritycode());
                           
            } catch (NumberFormatException e) {
                System.out.println("Security Code should be numeric");
                ccCheck = false;
            }
    		
    	}else {
    		System.out.println("Security code cannot be blank");
    	}
    	
    	
    	if(or.getCardType() == null || or.getCardType().isEmpty()) {
    		System.out.println("Card Type cannot be empty");
    		ccCheck = false;
    	}
    	
        return ccCheck; // return false if the credit card is invalid
    }
    
    
    
	
}

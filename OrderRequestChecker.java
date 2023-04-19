package com.makeorder.security;

import com.makeorder.vo.OrderRequest;

public class OrderRequestChecker {

	public boolean verifyOrderRequest(OrderRequest orderRequest) {
	        // Check if the customer name and product are not null or empty
//	        if (orderRequest.getCustomerName() == null || orderRequest.getCustomerName().isEmpty()
//	                || orderRequest.getProduct() == null || orderRequest.getProduct().isEmpty()) {
//	            return false;
//	        }
//
//	        // We can more checks based on product specification and quantity.
//	        
//	        // All checks passed, order request is valid
//	        return true;
//	    }
	 
		 
		// Check if the credit card number and expiration date are not null or empty
		
		boolean verifyOrder =true;
		
		if(orderRequest.getItem() ==null || orderRequest.getItem().isEmpty()) {
			System.out.println("Item cannot be null or blank");
			verifyOrder = false;
		}
		
		
		if (orderRequest.getPrice() < 0) {

			System.out.println("Product price can not be negative.");
			verifyOrder = false;
		}
      
		if(orderRequest.getQuantity() == 0) {
			
			System.out.println("Quantity should be greater than 0");
			verifyOrder = false;
		}
		
        
		return verifyOrder;
	
	
	}
}

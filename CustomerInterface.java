package com.makeorder.application;

import java.util.Scanner;

import com.makeorder.vo.OrderRequest;

public class CustomerInterface {

	 public OrderRequest createOrderRequest() {
	      
		    Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter Item: ");
	        String item = scanner.nextLine();
	        
	        System.out.print("Enter Quantity: ");
	        int quantity = scanner.nextInt();
	        
	        System.out.print("Enter Price: ");
	        int price = scanner.nextInt();
	        
	        System.out.print("Enter Credit Card Number: ");
	        String cardNo = scanner.next();
	        
	        System.out.print("Enter Expiry Date: ");
	        String date = scanner.next();
	        
	        System.out.print("Enter Card Type: ");
	        String cardType = scanner.next();
	        
	        System.out.print("Enter securitycode: ");
	        String securityCode = scanner.next();

	        // Use the customer name and product in the order request
	        OrderRequest orderRequest = new OrderRequest();
	        orderRequest.setItem(item);
	        orderRequest.setQuantity(quantity);
	        orderRequest.setPrice(price);
	        orderRequest.setCreditCardNumber(cardNo);
            orderRequest.setExpDate(date);
            orderRequest.setCardType(cardType);
            orderRequest.setSecuritycode(securityCode);
		  
	        return orderRequest;
	    }

	    public void displayOrderConfirmation() {
	        // Display an order confirmation message to the user
	    }
	
	
}

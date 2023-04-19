package com.makeorder.application;

import java.util.Scanner;

public class BankInterface {

	
	
	public int enterAuthCode() {
	
		System.out.println("If credit card info is correct, Please enter authorization code:");
		Scanner scanner = new Scanner(System.in);
		int authcode = scanner.nextInt();
		return authcode;
		
	}
		
	public boolean authorizePayment(byte[] encryptedCreditCardNumber, int authcode) {
		
		 if (authcode >= 1000 && authcode <= 9999) {
	            return true;
	        } else {
	            return false;
	        }
		
	}

	
	
}

package com.makeorder.application;

import java.security.PublicKey;
import java.util.Base64;

import com.makeorder.security.Encryption;
import com.makeorder.vo.OrderRequest;

public class PurchaseOrderManagement {

	public String processOrder(OrderRequest orderRequest, PublicKey publicKey) {

		String confirmation = "";
		// Encrypt the credit card number using the Encryption class
		Encryption encryption;
		try {
			encryption = new Encryption();

			byte[] encryptedCreditCardNumber = encryption.encrypt(orderRequest.getCreditCardNumber().getBytes());

			// Convert the encrypted credit card number to a string for display purposes
			String encryptedCreditCardNumberString = Base64.getEncoder().encodeToString(encryptedCreditCardNumber);

			// Display the encrypted credit card number to the user
			System.out.println("Encrypted credit card number: " + encryptedCreditCardNumberString);

			// Display the encrypted credit card number and prompt for an authorization code
			// using the BankInterface class
			BankInterface bankInterface = new BankInterface();
			int authcode = bankInterface.enterAuthCode();
			boolean isAuthorized = bankInterface.authorizePayment(encryptedCreditCardNumber, authcode);

			if (!isAuthorized) {
				System.out.println("Credit Card is declined , Please process order again.");
			} else {

				DeliveryOrder deliveryOrder = new DeliveryOrder();
				confirmation = deliveryOrder.createOrder(orderRequest, publicKey);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return confirmation;

	}

}

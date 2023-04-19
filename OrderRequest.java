package com.makeorder.vo;

import java.io.*;
import java.io.IOException;

public class OrderRequest {

	private String item;
	private int quantity;
	private int price;
	private String creditCardNumber;
	private String cardType;
	private String expDate;
	private String securitycode;
	private byte[] signature;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getSecuritycode() {
		return securitycode;
	}

	public void setSecuritycode(String securitycode) {
		this.securitycode = securitycode;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}
	
	
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public byte[] toByteArray() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeUTF(item);
		dos.writeInt(quantity);
		dos.writeInt(price);
		dos.writeUTF(creditCardNumber);
		dos.writeUTF(expDate);
		dos.writeUTF(securitycode);
		dos.writeUTF(cardType);
		dos.flush();
		return baos.toByteArray();
	}
}

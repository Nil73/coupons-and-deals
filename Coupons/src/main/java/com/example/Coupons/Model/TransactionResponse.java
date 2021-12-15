package com.example.Coupons.Model;

public class TransactionResponse {

    // for what responses will I be showing to the user
    private Order order;
    private double price;
    private String transactionId;
    private String message;
    
    
	public TransactionResponse() {
		super();
	}


	public TransactionResponse(Order order, double price, String transactionId, String message) {
		super();
		this.order = order;
		this.price = price;
		this.transactionId = transactionId;
		this.message = message;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	

}


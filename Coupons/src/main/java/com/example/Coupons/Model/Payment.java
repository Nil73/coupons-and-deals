package com.example.Coupons.Model;

public class Payment {


    private String paymentId;  // auto generated while doing rest api call
    private String paymentStatus; // for this I have made a method in service
    private String transactionId; // will be auto generated
    private String orderId; // will be taken from order entity
    private double price;   // will be taken from order entity
    
    
	public Payment() {
		super();
	}


	public Payment(String paymentId, String paymentStatus, String transactionId, String orderId, double price) {
		super();
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.price = price;
	}


	public String getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
    
	
	
    
}

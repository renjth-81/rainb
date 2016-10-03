package com.renjith.rainb.init;

public class PaymentError extends Exception {

	private static final long serialVersionUID = 1L;

	public PaymentError(String message) {
		super(message);
	}

}

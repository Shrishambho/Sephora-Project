package com.sephora.exception;

public class PaymentsException extends RuntimeException {

	public PaymentsException() {
		
	}
	
    public PaymentsException(String message) {
		super(message);
	}
}

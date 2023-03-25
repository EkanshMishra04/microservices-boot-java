package com.nagarro.AccountService.customExceptions;

public class RequestedResourceNotFoundException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public RequestedResourceNotFoundException() {
		super("Account not found Exception !!");
		
	}

	public RequestedResourceNotFoundException(String message) {
		super(message);
		
	}
	
	

}

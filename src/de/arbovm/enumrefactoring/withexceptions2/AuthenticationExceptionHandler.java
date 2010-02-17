package de.arbovm.enumrefactoring.withexceptions2;

import stubs.BusinessException;


public class AuthenticationExceptionHandler {

	private final String message;
	
	public AuthenticationExceptionHandler(Exception e) throws Exception {
		if (UserNotFoundException.class.isInstance(e)) {
			message = "User not found";

		} else if  (IncorrectPasswordException.class.isInstance(e)) {
			message = "Incorrect password";
			
		} else if  (BusinessException.class.isInstance(e)) {
			message = "Unknown Error. Please try again.";
			
		} else {
			throw e;
		}
	}

	public String getMessage() {
		return message;
	}
}

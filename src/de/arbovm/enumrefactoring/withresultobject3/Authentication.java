package de.arbovm.enumrefactoring.withresultobject3;

import stubs.User;

public class Authentication {

	public static final Authentication USER_NOT_FOUND = new Authentication();
	public static final Authentication INCORRECT_PASSWORD = new Authentication();
	public static final Authentication ERROR = new Authentication();
	
	private User user = null;
	
	private Authentication() {}
	
	private Authentication(User user) {
		this.user = user;
	}
	
	public static Authentication succeeded(User user) {
		return new Authentication(user);
	}

	public User getUser() {
		return user;
	}
	
	public boolean isSucceeded() {
		return user != null;
	}

	public boolean isUserNotFound() {
		return USER_NOT_FOUND.equals(this);
	}

	public boolean isIncorrectPassword() {
		return INCORRECT_PASSWORD.equals(this);
	}
	
	public boolean isError() {
		return ERROR.equals(this);
	}
}

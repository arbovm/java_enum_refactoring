package de.arbovm.enumrefactoring.withresultobject2;

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

}

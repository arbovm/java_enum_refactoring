package de.arbovm.enumrefactoring.encapsulatedenum;

import stubs.User;

public class Authentication {
	
	private enum Result { USER_NOT_FOUND, INCORRECT_PASSWORD, ERROR};
	
	private User user = null;
	private Result result = null;
	
	public static Authentication userNotFound() {
		return new Authentication(){{
			setResult(Result.USER_NOT_FOUND);
		}};
	}
	
	public static Authentication incorrectPassword() {
		return new Authentication(){{
			setResult(Result.INCORRECT_PASSWORD);
		}};
	}
	
	public static Authentication error() {
		return new Authentication(){{
			setResult(Result.ERROR);
		}};
	}
	
	public static Authentication succeeded(final User user) {
		return new Authentication() {{
			setUser(user);
		}};
	}
	
	public boolean isSucceeded() {
		return user != null;
	}

	public boolean isUserNotFound() {
		return Result.USER_NOT_FOUND.equals(result);
	}

	public boolean isIncorrectPassword() {
		return Result.INCORRECT_PASSWORD.equals(result);
	}
	
	public boolean isError() {
		return Result.ERROR.equals(result);
	}
	
	public String getErrorMessage(){
		if (isUserNotFound()) return "User not found";
		if (isIncorrectPassword()) return "Incorrect password";
		if (isError()) return "Unknown Error. Please try again.";
		return null;
	}

	protected void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	protected void setResult(Result result) {
		this.result = result;
	}
}

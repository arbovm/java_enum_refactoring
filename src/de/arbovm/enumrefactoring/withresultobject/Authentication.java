package de.arbovm.enumrefactoring.withresultobject;

public class Authentication {

	public static final Authentication USER_NOT_FOUND = new Authentication();
	public static final Authentication INCORRECT_PASSWORD = new Authentication();
	public static final Authentication ERROR = new Authentication();
	public static final Authentication SUCCEEDED = new Authentication();
}

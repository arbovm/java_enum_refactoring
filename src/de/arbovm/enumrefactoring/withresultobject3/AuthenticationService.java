package de.arbovm.enumrefactoring.withresultobject3;

import stubs.BusinessException;
import stubs.SessionService;
import stubs.User;
import stubs.UserRepository;

public class AuthenticationService {

	private UserRepository userRepository;
	private SessionService sessionService;

	public Authentication authenticate(String username, String password) {
		
		User user = userRepository.getById(username);

		if (user == null) return Authentication.USER_NOT_FOUND;
		
		if (!user.passwordEquals(password)) return Authentication.INCORRECT_PASSWORD;
		
		try {
			sessionService.signIn(user);
			return Authentication.succeeded(user);
			
		} catch (BusinessException e) {
			return Authentication.ERROR;
		}
	}
}
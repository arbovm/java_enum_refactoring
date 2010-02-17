package de.arbovm.enumrefactoring.withexceptions;

import stubs.BusinessException;
import stubs.SessionService;
import stubs.User;
import stubs.UserRepository;

public class AuthenticationService {

	private UserRepository userRepository;
	private SessionService sessionService;

	public User authenticate(String username, String password) throws UserNotFoundException, IncorrectPasswordException, BusinessException {
		
		User user = userRepository.getById(username);

		if (user == null) throw new UserNotFoundException();
		
		if (!user.passwordEquals(password)) throw new IncorrectPasswordException();
		
		sessionService.signIn(user);
		
		return user;
	}
}
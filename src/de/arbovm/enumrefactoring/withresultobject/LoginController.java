package de.arbovm.enumrefactoring.withresultobject;

import stubs.ModelMap;
import stubs.UserRepository;

public class LoginController {
	
	private AuthenticationService authenticationService;
	private UserRepository userRepository;

	public String submit(String username, String password, ModelMap model) {
		
		Authentication authentication = authenticationService.authenticate(username, password);
		
		if (Authentication.SUCCEEDED.equals(authentication)) {
			model.addAttribute("user", userRepository.getById(username));
			return "redirect:/";
		}
		
		if (Authentication.USER_NOT_FOUND.equals(authentication)) {
			model.addAttribute("message", "User not found");
			
		} else if (Authentication.INCORRECT_PASSWORD.equals(authentication)) {
			model.addAttribute("message", "Incorrect password");
			
		} else if (Authentication.ERROR.equals(authentication)) {
			model.addAttribute("message", "Unknown Error. Please try again.");
		}
		return "redirect:/login.html";
	}
}

package de.arbovm.enumrefactoring.withresultobject3;

import stubs.ModelMap;

public class LoginController {
	
	private AuthenticationService authenticationService;

	public String submit(String username, String password, ModelMap model) {
		
		Authentication authentication = authenticationService.authenticate(username, password);
		
		if (authentication.isSucceeded()) {
			model.addAttribute("user", authentication.getUser());
			return "redirect:/";
		}
		
		if (authentication.isUserNotFound()) {
			model.addAttribute("message", "User not found");
			
		} else if (authentication.isIncorrectPassword()) {
			model.addAttribute("message", "Incorrect password");
			
		} else if (authentication.isError()) {
			model.addAttribute("message", "Unknown Error. Please try again.");
		}
		return "redirect:/login.html";
	}
}

package de.arbovm.enumrefactoring.encapsulatedenum;

import stubs.ModelMap;

public class LoginController {
	
	private AuthenticationService authenticationService;

	public String submit(String username, String password, ModelMap model) {
		
		Authentication authentication = authenticationService.authenticate(username, password);
		
		if (authentication.isSucceeded()) {
			model.addAttribute("user", authentication.getUser());
			return "redirect:/";
		} else  {
			model.addAttribute("message", authentication.getErrorMessage());
			return "redirect:/login.html";
		}
	}
}

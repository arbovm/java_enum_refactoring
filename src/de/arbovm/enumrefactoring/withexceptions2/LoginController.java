package de.arbovm.enumrefactoring.withexceptions2;

import stubs.ModelMap;
import stubs.User;

public class LoginController {
	
	private AuthenticationService authenticationService;

	public String submit(String username, String password, ModelMap model) throws Exception {
		
		try {
			User user = authenticationService.authenticate(username, password);
			model.addAttribute("user", user);
			return "redirect:/";
			
		} catch (Exception e) {
			model.addAttribute("message", new AuthenticationExceptionHandler(e).getMessage());
			return "redirect:/login.html";
		}
	}
}

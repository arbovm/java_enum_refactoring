package de.arbovm.enumrefactoring.withexceptions;

import stubs.BusinessException;
import stubs.ModelMap;
import stubs.User;

public class LoginController {
	
	private AuthenticationService authenticationService;

	public String submit(String username, String password, ModelMap model) {
		
		try {
			User user = authenticationService.authenticate(username, password);
			model.addAttribute("user", user);
			return "redirect:/";
			
		} catch (UserNotFoundException e) {
			model.addAttribute("message", "User not found");
			return "redirect:/login.html";
			
		} catch (IncorrectPasswordException e) {
			model.addAttribute("message", "Incorrect password");
			return "redirect:/login.html";
			
		} catch (BusinessException e) {
			model.addAttribute("message", "Unknown Error. Please try again.");
			return "redirect:/login.html";
		}
	}
}

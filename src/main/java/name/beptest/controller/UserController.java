package name.beptest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import name.beptest.dto.UserDTO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/loginPage")
	public String loginPage(Model model) {
		return "/user/login";
	}
	
	@GetMapping("/signUpPage")
	public String signUpPage(Model model) {
		return "/user/signUp";
	}
	
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute UserDTO userDto, Model model) {
		System.out.println(userDto);
		return null;
	}
}

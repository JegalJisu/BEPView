package name.beptest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import name.beptest.dto.UserDTO;
import name.beptest.service.UserService;
import name.beptest.utils.Constrant;
import name.beptest.utils.Utils;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
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
		userDto.setIdx(Utils.uuid());
		userDto.setUserRole(Constrant.USER_ROLE_USER);
		userDto.setRegDate(Utils.strDate());
		userDto.setChgDate(Utils.strDate());
		userService.addUser(userDto);
		System.out.println(userDto);
		
		userService.allUser();
		return null;
	}
}

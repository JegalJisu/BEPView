package name.beptest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import name.beptest.dto.UserDTO;
import name.beptest.service.UserService;
import name.beptest.utils.Constrant;
import name.beptest.utils.Utils;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loginPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (!Utils.isNull(session.getAttribute(Constrant.HTTP_SESSION_LOGIN_USER))) {
			return "redirect:/main";
		}
		
		return "/user/login";
	}
	
	@GetMapping("/signUp")
	public String signUpPage() {
		return "/user/signUp";
	}
	
	@PostMapping("/signUpProc")
	public ModelAndView signUp(@ModelAttribute UserDTO userDto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/user/login");
		
		userDto.setIdx(Utils.uuid());
		userDto.setUserRole(Constrant.USER_ROLE_USER);
		userDto.setRegDate(Utils.strDate());
		userDto.setChgDate(Utils.strDate());
		userService.addUser(userDto);
		
		return mav;
	}
	
	@PostMapping("/loginProc")
	@ResponseBody
	public JSONObject loginMatch(@ModelAttribute UserDTO userDto, HttpServletRequest request) {
		JSONObject jsonObj = new JSONObject();
		HttpSession session = request.getSession();
		
		
		try {
			UserDTO loginUser = userService.loginUser(userDto);
			
			if (!Utils.isNull(loginUser)) {
				jsonObj.put("code", Constrant.HTTP_RESULT_CODE_SUCCESS);
				session.setAttribute(Constrant.HTTP_SESSION_LOGIN_USER, loginUser);
			}
			else {
				jsonObj.put("code", Constrant.HTTP_RESULT_CODE_USER_INFO_FAIL);
			}
		} catch(Exception e) {
			jsonObj.put("code", Constrant.HTTP_RESULT_CODE_COMMON_FAIL);
		}
		return jsonObj;
	}
}

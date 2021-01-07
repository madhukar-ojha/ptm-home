package ptm.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ptm.home.reqprocessor.LoginReqProcessor;
import ptm.home.vo.LoginVO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {
	private static int t_count;

	public LoginController() {
		System.out.println("---- LoginController count : " + ++t_count);
	}

	@Autowired
	private LoginReqProcessor loginReqProcessor;

	@GetMapping
	public String welcome(ModelMap modelMap) {
		return loginReqProcessor.welcome(modelMap);
	}

	@PostMapping(value = "/login")
	public String login(@Valid LoginVO loginVO, BindingResult bindingResult, ModelMap modelMap,
						HttpServletRequest request) {
		return "project";
	//	return loginReqProcessor.login(loginVO, bindingResult, modelMap, request);
	}

	@GetMapping(value = "/logout")
	public String logout(ModelMap model, HttpServletRequest request) {
		return loginReqProcessor.logout(model, request);
	}

	@GetMapping(value = "/error") 
	public String error(ModelMap model,	HttpServletRequest request) { 
		return "error"; 
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView loginException(RuntimeException loginException1, HttpServletRequest req, Exception e) {
		System.err.println("exception: " + loginException1.getMessage());
		return loginReqProcessor.loginException(loginException1);
	}

}

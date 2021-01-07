package ptm.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/client")
public class ClientController {
	private static int t_count;

	public ClientController() {
		System.out.println("---- ClientController count : " + ++t_count);
	}

	@GetMapping
	public String home(ModelMap model, HttpSession session) {
		return "client";
	}

}

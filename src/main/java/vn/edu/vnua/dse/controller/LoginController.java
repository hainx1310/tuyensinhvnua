package vn.edu.vnua.dse.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(boolean bool) {
		System.out.println("login thanh cong");
		return "redirect: home";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Xin chào " + principal.getName() + ", <br> Bạn không có quyền truy cập trang này!");
		} else {
			model.addAttribute("msg", "Bạn không có quyền truy cập trang này!");
		}

		return "403Page";
	}
}

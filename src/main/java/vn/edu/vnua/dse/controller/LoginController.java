package vn.edu.vnua.dse.controller;

import java.security.Principal;

import org.mindrot.jbcrypt.BCrypt;
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
		
		String password = "123456";
		String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
		System.out.println("BCrypt hash: " + hash);
		
		boolean checkPassword = BCrypt.checkpw("123456", "$2a$12$i/VjaqcMbpucOB.jchCjbOTrq623pV6YqS3C7kHC7585JzAVjqAWG");
		boolean checkPassword1 = BCrypt.checkpw("123456", "$2a$12$jZl/YEld0oPcBP7iJqtpxeGdVUv1gDJlalR8xN/Wt9MnZzTyPU.7a");
		System.out.println(checkPassword);
		System.out.println(checkPassword1);
		
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

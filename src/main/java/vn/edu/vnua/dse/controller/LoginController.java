package vn.edu.vnua.dse.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.vnua.dse.entity.User;
import vn.edu.vnua.dse.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	/**
	 * Phuong thuc kiem tra dang nhap vao he thong
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, HttpSession session) {

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// check login
		boolean checkUsername = userService.checkExistUserByName(username);

		if (checkUsername) {
			// lay thong tin user thong qua username
			List<User> listResul = new ArrayList<User>();
			listResul = userService.getUserByUsername(username);
			if (listResul != null && listResul.size() > 0) {
				// lay salt
				if (bcrypt.matches(password, listResul.get(0).getPassword())) {
					// TH tai khoan bi khoa
					if (!listResul.get(0).isStatus()) {
						model.addAttribute("error", "true");
						model.addAttribute("message", "Tài khoản đã bị khóa.");
						return "redirect: login";
					}
					if (session.getAttribute("user") != null) {
						System.out.println("bla bla");
						session.setAttribute("user", listResul.get(0));
					}

					return "redirect: home";
				}

			}
		}

		return "redirect: login";
	}

	/**
	 * Phuong thuc xu ly login that bai
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginFailed(ModelMap model) {
		model.addAttribute("error", "true");
		model.addAttribute("message", "Tài khoản hoặc mật khẩu không chính xác");
		return "login";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Xin chào, " + principal.getName() + "!, <br> Bạn không có quyền truy cập trang này!");
		} else {
			model.addAttribute("msg", "Bạn không có quyền truy cập trang này!");
		}

		return "403Page";
	}
}

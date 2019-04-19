package vn.edu.vnua.dse.controller;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.vnua.dse.entity.User;
import vn.edu.vnua.dse.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/UserManagement", method = RequestMethod.GET)
	public String channel() {
		return "admin/user";
	}

	/**
	 * Phuong thuc them moi 1 user
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createUser(User user, HttpServletRequest request, Model model) {

		// kiem tra username co ton tai ko
		if (userService.checkExistUserByName(user.getUsername())) {
			model.addAttribute("message", "Tên tài khoản đã tồn tại! Mời bạn nhập tên khác.");
			return new ModelAndView("redirect:" + "admin/user");
		}

		// get type role
		boolean role;
		role = request.getParameter("role") != null
				? Integer.parseInt(request.getParameter("role")) == 1 ? true : false
				: false;
		user.setRole(role);

		// random salt
		String salt = "randomString";
		// ma hoa mk
		user.setPasswordSalt(salt);
		user.setPassword(BCrypt.hashpw(salt.concat(user.getPassword()), BCrypt.gensalt(12)));

		try {
			userService.createUser(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ModelAndView("redirect:" + "/admin/user/UserManagement");
	}
}

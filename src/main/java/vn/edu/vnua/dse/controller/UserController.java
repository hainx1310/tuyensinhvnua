package vn.edu.vnua.dse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class UserController {

	@RequestMapping(value = "admin/UserManagement", method = RequestMethod.GET)
	public String channel() {
		return "admin/user";
	}
}

package vn.edu.vnua.dse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotificationController {
	@RequestMapping(value = "/notification")
	public String loadComment() {
		return "notification";
	}
}

package vn.edu.vnua.dse.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.vnua.dse.entity.User;
import vn.edu.vnua.dse.service.UserService;

@RestController
@RequestMapping("api")
public class UserApi {

	@Autowired
	private UserService userService;

	/**
	 * Api lấy ra danh sách user
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/user" }, method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> listUser = new ArrayList<User>();
		listUser = userService.getListUser();
		return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
	}
}

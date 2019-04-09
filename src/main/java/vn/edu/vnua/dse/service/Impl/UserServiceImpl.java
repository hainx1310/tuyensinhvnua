package vn.edu.vnua.dse.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.vnua.dse.dao.UserDAO;
import vn.edu.vnua.dse.entity.User;
import vn.edu.vnua.dse.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Override
	public List<User> getListUser() {
		return userDao.getListUser();
	}

}

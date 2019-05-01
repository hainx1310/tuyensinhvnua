package vn.edu.vnua.dse.service.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.edu.vnua.des.co.CustomUserDetails;
import vn.edu.vnua.dse.dao.UserDAO;
import vn.edu.vnua.dse.entity.User;

@Service("userServiceDetails")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO userDao;

	/*
	 * (non-Javadoc) Phuong thuc tra ve thong tin user dung cho file cau hinh spring
	 * security
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> listUser = userDao.getUserByUsername(username);
		User user;
		CustomUserDetails userDetails;
		if (listUser != null && listUser.size() > 0) {
			user = listUser.get(0);
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			String roleName = user.isRole() == true ? "ROLE_ADMIN" : "ROLE_EDITOR";
			grantedAuthorities.add(new SimpleGrantedAuthority(roleName));
			userDetails = new CustomUserDetails(user);
			return userDetails;
		}
		return null;
	}
}

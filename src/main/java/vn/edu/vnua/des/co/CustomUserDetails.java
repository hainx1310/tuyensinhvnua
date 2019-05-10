package vn.edu.vnua.des.co;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import vn.edu.vnua.dse.entity.User;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private User user;

	public CustomUserDetails(final User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		String roleName = user.getRole();
		grantedAuthorities.add(new SimpleGrantedAuthority(roleName));

		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return user == null ? null : user.getPassword();
	}

	@Override
	public String getUsername() {
		return user == null ? null : user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isStatus();
	}

	public String getName() {
		return user.getName() == null ? user.getUsername() : user.getName();
	}

	public String getAvatarUrl() {
		return user.getAvatarUrl() == null ? "/resources/images/avatar_user.png" : user.getAvatarUrl();
	}

	public String getRoleName() {
		String roleName = "";
		switch (user.getRole()) {
		case "ROLE_ADMIN":
			roleName = "Quản trị viên";
			break;
		case "ROLE_EDITOR":
			roleName = "Biên tập viên";
			break;
		case "ROLE_COLLABORARATORS":
			roleName = "Cộng tác viên";
			break;
		default:
			roleName = "Cộng tác viên";
		}
		return roleName;
	}

}

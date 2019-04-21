package vn.edu.vnua.dse.service;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);
}

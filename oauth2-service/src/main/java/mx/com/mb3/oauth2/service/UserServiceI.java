package mx.com.mb3.oauth2.service;

import java.util.List;

import mx.com.mb3.oauth2.model.Authority;
import mx.com.mb3.oauth2.model.Users;

public interface UserServiceI {
	void createUser(Users u, List<Authority> authorities);
	boolean isUserAvailable(String username);
	Users getByLogin(String login);
	Users update(Users u);
	void delete(Users u);
}

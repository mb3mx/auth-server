package mx.com.mb3.oauth2.dao;

import mx.com.mb3.oauth2.model.Users;

public interface UserDaoI  extends GenericDaoI<Users, Long>{
	boolean isUserAvailable(String login);
	Users loadUserByUsername(String username);
}

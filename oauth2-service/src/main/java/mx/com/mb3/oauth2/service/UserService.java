package mx.com.mb3.oauth2.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.com.mb3.oauth2.dao.UserDaoI;
import mx.com.mb3.oauth2.model.Authority;
import mx.com.mb3.oauth2.model.UserAuthority;
import mx.com.mb3.oauth2.model.Users;
import mx.com.mb3.oauth2.service.utils.Constants;

@Service
public class UserService implements UserServiceI, UserDetailsService {
	@Autowired
	private UserDaoI userDao;

	public void createUser(Users u, List<Authority> authorities) {
	}

	public boolean isUserAvailable(String username) {
		return false;
	}

	public Users getByLogin(String login) {
		return null;
	}

	public Users update(Users u) {
		return null;
	}

	public void delete(Users u) {
	}
	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userDao.loadUserByUsername(username);
		
		   if (user == null)
			   throw new UsernameNotFoundException(String.format(Constants.MSG_ERROR_USUARIO_NO_REGISTRADO, username));

			return new org.springframework.security.core.userdetails.User(user.getUsername(), 
					        user.getPassword(),
							Boolean.valueOf(user.isEnabled()), 
							Boolean.valueOf(user.isAccountNonExpired()), 
							Boolean.valueOf(user.isCredentialNonExpired()), 
							Boolean.valueOf(user.isAccountNonLocked()),
							getAuthorities(user.getUserAuthorities())
						   );
	}

	
	private Collection<? extends GrantedAuthority> getAuthorities(Set<UserAuthority> userAuthorities) {
		List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>(2);

		for (UserAuthority userAuthority : userAuthorities) {
			authoritiesList.add(new SimpleGrantedAuthority(userAuthority.getAuthority().getAuthority()));
			System.out.println("ROLES --> " + userAuthority.getAuthority().getAuthority());
		}
		
		return authoritiesList;
	}

	
}
package mx.com.mb3.oauth2.dao;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.mb3.oauth2.model.Users;

@Repository
public class UserDao extends GenericDao<Users, Long> implements UserDaoI {

	@Override
	protected Class<Users> getClazz() {
		return Users.class;
	}

	public boolean isUserAvailable(String login) {

		StringBuilder hql = new StringBuilder();
		hql.append("select count(*) ");
		hql.append("from ");
		hql.append("Users ");
		hql.append("user ");
		hql.append("where s.login = :login");

		Query query = getCurrentSession().createQuery(hql.toString());
		query.setParameter("login", login);

		Long count = (Long) query.list().get(0);

		return count < 1;
	}

	public Users loadUserByUsername(String username) {
		Users user = null;

		StringBuilder hql = new StringBuilder();

		hql.append("select user ");
		hql.append("from ");
		hql.append("Users ");
		hql.append("user ");
		hql.append("where user.username = :username");

		try {
			user = (Users) getCurrentSession().createQuery(hql.toString()).setParameter("username", username).uniqueResult();
		} catch (NoResultException nre) {
			System.out.println("No se encontro el usuario --> " + nre.toString());
		}

		return user;
	}

}
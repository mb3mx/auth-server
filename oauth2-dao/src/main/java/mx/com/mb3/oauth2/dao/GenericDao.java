package mx.com.mb3.oauth2.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class GenericDao<T extends Serializable, ID extends Serializable> implements GenericDaoI<T, ID> {
	protected Class<T> clazz = getClazz();
	protected abstract Class<T> getClazz();
    protected SessionFactory sessionFactory;

    @Autowired
	public void init(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	

	public T findOne(ID id) {
		return sessionFactory.getCurrentSession().load(getClazz(), id);
	}
	
	public List<T> findAll() {
		return sessionFactory.getCurrentSession().createQuery( "from " + clazz.getName() +" order by id desc ").list();
		//return sessionFactory.getCurrentSession().createCriteria(getClazz()).list();
	}
	
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}
	
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}
	
	public void saveOrUpdate(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}
	
	public void delete(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	
}
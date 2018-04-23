package mx.com.mb3.oauth2.dao;

import java.util.List;

public interface GenericDaoI <T,ID>{
	T findOne(ID id);
	List<T> findAll();
	void save(T t);
	void update (T t);
	void saveOrUpdate(T t);
	void delete(T t);
}

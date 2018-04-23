package mx.com.mb3.oauth2.dao;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import mx.com.mb3.oauth2.model.OauthClientDetail;

@Repository
public class OauthClientDetailDao  extends GenericDao<OauthClientDetail, String> implements OauthClientDetailDaoI {

	@Override
	protected Class<OauthClientDetail> getClazz() {
		return OauthClientDetail.class;
	}

	public boolean isClientAvailable(String clientId) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("select count(*) ");
		hql.append("from ");
		hql.append("OauthClientDetail ocd ");
		hql.append("where  ocd.clientId = :clientId");
		
		Query query = getCurrentSession().createQuery(hql.toString());
		query.setParameter("clientId", clientId);
		
		Long count = (Long) query.list().get(0);
		
		return count >= 1 ? true : false;
	}

	public OauthClientDetail loadClientById(String clientId) {
		OauthClientDetail client = null;
		
		StringBuilder hql = new StringBuilder();
		
		hql.append("select ocd ");
		hql.append("from ");
		hql.append("OauthClientDetail ocd ");
		hql.append("where  ocd.clientId = :clientId");
		
		try{
			Query query = getCurrentSession().createQuery(hql.toString());
			query.setParameter("clientId", clientId);
			
			if (query.list().get(0) instanceof OauthClientDetail){
				client = (OauthClientDetail) query.list().get(0);
			}
			
		}catch (NoResultException nre){
				 System.out.println("No se encontro el cliente --> " + nre.toString());
		}
		
		return client;
		
	}

}
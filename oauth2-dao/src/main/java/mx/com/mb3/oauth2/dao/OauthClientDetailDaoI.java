package mx.com.mb3.oauth2.dao;

import mx.com.mb3.oauth2.model.OauthClientDetail;

public interface OauthClientDetailDaoI  extends GenericDaoI<OauthClientDetail, String>{
	
	public boolean isClientAvailable(String clientId);
	public OauthClientDetail loadClientById(String clientId);
	
}

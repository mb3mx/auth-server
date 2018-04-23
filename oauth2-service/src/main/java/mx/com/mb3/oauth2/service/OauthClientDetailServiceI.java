package mx.com.mb3.oauth2.service;

import mx.com.mb3.oauth2.model.OauthClientDetail;

public interface OauthClientDetailServiceI {
	void createClient(OauthClientDetail client);
	boolean isUserAvailable(String clientId);
	OauthClientDetail getByClientId(String clientId);
	OauthClientDetail update(OauthClientDetail client);
	void delete(OauthClientDetail client);
}

package mx.com.mb3.oauth2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import mx.com.mb3.oauth2.dao.OauthClientDetailDaoI;
import mx.com.mb3.oauth2.model.OauthClientDetail;
import mx.com.mb3.oauth2.service.utils.Constants;

@Service
public class OauthClientDetailService implements OauthClientDetailServiceI, ClientDetailsService {

	@Autowired
	private OauthClientDetailDaoI oauthClientDetailDao;
	
	public void createClient(OauthClientDetail client) {

	}

	public boolean isUserAvailable(String clientId) {
		return false;
	}

	public OauthClientDetail getByClientId(String clientId) {
		return null;
	}

	public OauthClientDetail update(OauthClientDetail client) {
		return null;
	}

	public void delete(OauthClientDetail client) {
	}

	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		
		if (!oauthClientDetailDao.isClientAvailable(clientId)){
			throw new ClientRegistrationException(String.format(Constants.MSG_ERROR_CLIENTE_NO_REGISTRADO, clientId));
		}
		
		OauthClientDetail client = oauthClientDetailDao.loadClientById(clientId);
		
		BaseClientDetails clientDetails = new BaseClientDetails();
		
		List<String> authorities = Arrays.asList(client.getAuthorizedGrantTypes().split(","));
		
		List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>();
		
		for (String s : authorities){
			authoritiesList.add(new SimpleGrantedAuthority(s));
		}
		
		Set<String> uris = new HashSet<String>(Arrays.asList(client.getWebServerRedirectUri().split(",")));
		
		clientDetails.setClientId(client.getClientId());
		clientDetails.setScope(Arrays.asList(client.getScope().split(",")));
		clientDetails.setAuthorizedGrantTypes(Arrays.asList(client.getAuthorizedGrantTypes().split(",")));
		clientDetails.setAuthorities(authoritiesList);
		clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity());
		clientDetails.setClientSecret(client.getClientSecret());
		clientDetails.setRegisteredRedirectUri(uris);
		clientDetails.setResourceIds(Arrays.asList(client.getResourceIds().split(",")));
		//clientDetails.setAdditionalInformation();
												
		String approve = client.getAutoapprove() == null ? "false" : "true";
		
		if(approve.equalsIgnoreCase("true"))
            clientDetails.setAutoApproveScopes(StringUtils.commaDelimitedListToSet(client.getAutoapprove()));
		else
            clientDetails.setAutoApproveScopes(new HashSet<String>());
				
		return clientDetails;
	}
	

}
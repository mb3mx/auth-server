package mx.com.mb3.oauth2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "oauth_client_token", schema = "public")
public class OauthClientToken implements Serializable {
	private static final long serialVersionUID = 1L;
	private String authenticationId;
	private String tokenId;
	private byte[] token;
	private String userName;
	private String clientId;
	private Date created;

	public OauthClientToken() {
	}

	@Id

	@Column(name = "authentication_id", unique = true, nullable = false)
	public String getAuthenticationId() {
		return this.authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	@Column(name = "token_id", nullable = false)
	public String getTokenId() {
		return this.tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	@Column(name = "token", nullable = false)
	public byte[] getToken() {
		return this.token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	@Column(name = "user_name", nullable = false)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "client_id", nullable = false)
	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 29)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}

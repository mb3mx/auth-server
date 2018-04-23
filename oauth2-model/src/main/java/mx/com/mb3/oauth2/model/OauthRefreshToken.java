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
@Table(name = "oauth_refresh_token", schema = "public")
public class OauthRefreshToken implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tokenId;
	private byte[] token;
	private byte[] authentication;
	private Date created;

	public OauthRefreshToken() {
	}


	@Id

	@Column(name = "token_id", unique = true, nullable = false)
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

	@Column(name = "authentication", nullable = false)
	public byte[] getAuthentication() {
		return this.authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
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

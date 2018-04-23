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
@Table(name = "oauth_code", schema = "public")
public class OauthCode implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private byte[] authentication;
	private Date created;

	public OauthCode() {
	}

	@Id

	@Column(name = "code", unique = true, nullable = false)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

package mx.com.mb3.oauth2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "authority", schema = "public")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;
	private int authorityId;
	private String authority;
	private Date created;
	private Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>(0);

	public Authority() {
	}


	@Id
	@Column(name = "authority_id", unique = true, nullable = false)
	public int getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	@Column(name = "authority", nullable = false, length = 100)
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 29)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "authority")
	public Set<UserAuthority> getUserAuthorities() {
		return this.userAuthorities;
	}

	public void setUserAuthorities(Set<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}

}

package mx.com.mb3.oauth2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class UserAuthorityId implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;
	private int authorityId;

	public UserAuthorityId() {
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "authority_id", nullable = false)
	public int getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserAuthorityId))
			return false;
		UserAuthorityId castOther = (UserAuthorityId) other;

		return (this.getUserId() == castOther.getUserId()) && (this.getAuthorityId() == castOther.getAuthorityId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUserId();
		result = 37 * result + this.getAuthorityId();
		return result;
	}

}

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
@Table(name = "user_attempt", schema = "public")
public class UserAttempt implements Serializable {
	private static final long serialVersionUID = 1L;
	private int attemptId;
	private String username;
	private String attempts;
	private Date lastModified;
	private Date created;

	public UserAttempt() {
	}

	@Id

	@Column(name = "attempt_id", unique = true, nullable = false)
	public int getAttemptId() {
		return this.attemptId;
	}

	public void setAttemptId(int attemptId) {
		this.attemptId = attemptId;
	}

	@Column(name = "username", nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "attempts", nullable = false, length = 45)
	public String getAttempts() {
		return this.attempts;
	}

	public void setAttempts(String attempts) {
		this.attempts = attempts;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified", nullable = false, length = 29)
	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
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

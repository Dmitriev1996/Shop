package ru.projects.Shop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tokens")
@NamedQueries({
	@NamedQuery(name="findAllTokens", query="SELECT t FROM Token t"
		+ " ORDER BY t.Token DESC"), 
	@NamedQuery(name="findTokenByValue", query="SELECT t FROM Token t"
		+ " WHERE t.Token = :token") 
	})
public class Token {
	@Id
	@Column(name="TOKEN")
	private String Token;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CREDENTIAL_ID")
	private Credential Credential;
	
	public Token() {}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public Credential getCredential() {
		return Credential;
	}

	public void setCredential(Credential credential) {
		Credential = credential;
	}
	
	

}

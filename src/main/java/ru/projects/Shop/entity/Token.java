package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tokens")
@NamedQueries({
	@NamedQuery(name="findAllTokens", query="SELECT t FROM Token t"
		+ " ORDER BY t.Token DESC"), 
	@NamedQuery(name="findTokenByValue", query="SELECT t FROM Token t"
		+ " WHERE t.Token = :token") 
	})
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "token_ID")
public class Token implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TOKEN_ID")
	private Long Token_ID;
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

	public Long getToken_ID() {
		return Token_ID;
	}

	public void setToken_ID(Long token_ID) {
		Token_ID = token_ID;
	}
	
	

}

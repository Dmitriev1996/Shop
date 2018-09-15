package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="credentials")
@NamedQuery(name="findAllCredential", query="SELECT c FROM Credential c"
		+ " ORDER BY c.Credential_ID DESC")
public class Credential implements Serializable {
	@Id @GeneratedValue
	@Column(name="CREDENTIAL_ID")
	private Long Credential_ID;
	@Column(name="LOGIN")
	private String Login;
	@Column(name="PASSWORD")
	private String Password;
	@Column(name="ROLE")
	private String Role;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Credential")
	private Client Client;
	
	public Credential() {}

	public Long getCredential_ID() {
		return Credential_ID;
	}

	public void setCredential_ID(Long credential_ID) {
		Credential_ID = credential_ID;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}
	
	

}

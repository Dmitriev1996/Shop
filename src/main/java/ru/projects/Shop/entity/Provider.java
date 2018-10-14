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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="providers")
@NamedQuery(name="findAllProvider", query="SELECT p FROM Provider p"
		+ " ORDER BY p.Provider_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "provider_ID")
public class Provider implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PROVIDER_ID")
	private Long Provider_ID;
	@Column(name="NAME_OF_PROVIDER")
	private String NameOfProvider;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CITY_ID")
	private City City;
	@Column(name="ADRESS")
	private String Adress;
	@Column(name="EMAIL")
	private String Email;
	@Column(name="PHONE")
	private String Phone;
	
	public Provider() {}

	public Long getProvider_ID() {
		return Provider_ID;
	}

	public void setProvider_ID(Long provider_ID) {
		Provider_ID = provider_ID;
	}

	public String getNameOfProvider() {
		return NameOfProvider;
	}

	public void setNameOfProvider(String nameOfProvider) {
		NameOfProvider = nameOfProvider;
	}

	public City getCity() {
		return City;
	}

	public void setCity(City city) {
		City = city;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	
	

}

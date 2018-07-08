package ru.projects.Shop.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="providers")
public class Provider {
	@Id @GeneratedValue
	private Long Provider_ID;
	private String NameOfProvider;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Country_ID")
	private Country Country;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="City_ID")
	private City City;
	private String Adress;
	private String Email;
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

	public Country getCountry() {
		return Country;
	}

	public void setCountry(Country country) {
		Country = country;
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

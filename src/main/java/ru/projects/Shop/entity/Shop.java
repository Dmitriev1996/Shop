package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shops")
@NamedQuery(name="findAllShop", query="SELECT s FROM Shop s"
		+ " ORDER BY s.Shop_ID DESC")
public class Shop implements Serializable {
	@Id @GeneratedValue
	private Long Shop_ID;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="TypeShop_ID")
	private TypeShop TypeShop;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="Country_ID")
	private Country Country;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="Region_ID")
	private Region Region;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="City_ID")
	private City City;
	private String Adress;
	private String Phone;
	private String Email;
	
	public Shop() {}

	public Long getShop_ID() {
		return Shop_ID;
	}

	public void setShop_ID(Long shop_ID) {
		Shop_ID = shop_ID;
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

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public TypeShop getTypeShop() {
		return TypeShop;
	}

	public void setTypeShop(TypeShop typeShop) {
		TypeShop = typeShop;
	}

	public Region getRegion() {
		return Region;
	}

	public void setRegion(Region region) {
		Region = region;
	}
	
	
	
	
	

}

package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="shops")
@NamedQuery(name="findAllShop", query="SELECT s FROM Shop s"
		+ " ORDER BY s.Shop_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "shop_ID")
public class Shop implements Serializable {
	@Id @GeneratedValue
	@Column(name="SHOP_ID")
	private Long Shop_ID;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="TYPE_SHOP_ID")
	@JsonBackReference("TypeShop")
	private TypeShop TypeShop;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CITY_ID")
	@JsonBackReference("City")
	private City City;
	@Column(name="ADRESS")
	private String Adress;
	@Column(name="PHONE")
	private String Phone;
	@Column(name="EMAIL")
	private String Email;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="WAREHOUSE_ID")
	@JsonBackReference("Warehouse")
	private Warehouse Warehouse;
	
	public Shop() {}

	public Long getShop_ID() {
		return Shop_ID;
	}

	public void setShop_ID(Long shop_ID) {
		Shop_ID = shop_ID;
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

	public Warehouse getWarehouse() {
		return Warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		Warehouse = warehouse;
	}

	
	
	
	
	

}

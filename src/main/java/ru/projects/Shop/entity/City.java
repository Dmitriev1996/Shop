package ru.projects.Shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class City {
	@Id @GeneratedValue
	private Long City_ID;
	private String City;
	@OneToMany
	@JoinTable(name="city_shops", 
	joinColumns=@JoinColumn(name="City_ID"), 
	inverseJoinColumns=@JoinColumn(name="Shop_ID"))
	private List<Shop> ShopList;
	public City() {}

	public Long getCity_ID() {
		return City_ID;
	}

	public void setCity_ID(Long city_ID) {
		City_ID = city_ID;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}
	
	

}

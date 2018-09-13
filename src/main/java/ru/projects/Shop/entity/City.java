package ru.projects.Shop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="cities")
@NamedQuery(name="findAllCity", query="SELECT c FROM City c"
		+ " ORDER BY c.City_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "city_ID")
public class City implements Serializable {
	@Id @GeneratedValue
	@Column(name="CITY_ID")
	private Long City_ID;
	@Column(name="CITY")
	private String City;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="REGION_ID")
	@JsonBackReference
	private Region Region;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="City")
	@JsonManagedReference
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

	public List<Shop> getShopList() {
		return ShopList;
	}

	public void setShopList(List<Shop> shopList) {
		ShopList = shopList;
	}

	public Region getRegion() {
		return Region;
	}

	public void setRegion(Region region) {
		Region = region;
	}
	
	
	
	

}

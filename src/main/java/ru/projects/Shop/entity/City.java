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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="cities")
@NamedQuery(name="findAllCity", query="SELECT c FROM City c"
		+ " ORDER BY c.City_ID DESC")
public class City implements Serializable {
	@Id @GeneratedValue
	@Column(name="CITY_ID")
	private Long City_ID;
	@Column(name="CITY")
	private String City;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="region_cities", 
	joinColumns=@JoinColumn(name="CITY_ID"), 
	inverseJoinColumns=@JoinColumn(name="REGION_ID"))
	private Region Region;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="city_shops", 
	joinColumns=@JoinColumn(name="CITY_ID"), 
	inverseJoinColumns=@JoinColumn(name="SHOP_ID"))
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

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
@Table(name="regions")
@NamedQuery(name="findAllRegion", query="SELECT r FROM Region r"
		+ " ORDER BY r.Region_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "region_ID")
public class Region implements Serializable {
	@Id @GeneratedValue
	@Column(name="REGION_ID")
	private Long Region_ID;
	@Column(name="REGION")
	private String Region;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="COUNTRY_ID")
	@JsonBackReference
	private Country Country;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Region")
	@JsonManagedReference
	private List<City> CityList;
	
	public Region() {}

	public Long getRegion_ID() {
		return Region_ID;
	}

	public void setRegion_ID(Long region_ID) {
		Region_ID = region_ID;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public List<City> getCityList() {
		return CityList;
	}

	public void setCityList(List<City> cityList) {
		CityList = cityList;
	}

	public Country getCountry() {
		return Country;
	}

	public void setCountry(Country country) {
		Country = country;
	}
	
	
	
	
	

}

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
@Table(name="countries")
public class Country {
	@Id @GeneratedValue
	private Long Country_ID;
	private String Country;
	@OneToMany
	@JoinTable(name="region_country", 
	joinColumns=@JoinColumn(name="Country_ID"), 
	inverseJoinColumns=@JoinColumn(name="Region_ID"))
	private List<Region> RegionList;
	
	public Country() {}

	public Long getCountry_ID() {
		return Country_ID;
	}

	public void setCountry_ID(Long country_ID) {
		Country_ID = country_ID;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}
	
	

}

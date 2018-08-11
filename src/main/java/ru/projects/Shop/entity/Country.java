package ru.projects.Shop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="countries")
@NamedQuery(name="findAllCountry", query="SELECT c FROM Country c"
		+ " ORDER BY c.Country_ID DESC")
public class Country implements Serializable {
	@Id @GeneratedValue
	@Column(name="COUNTRY_ID")
	private Long Country_ID;
	@Column(name="COUNTRY")
	private String Country;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="region_country", 
	joinColumns=@JoinColumn(name="COUNTRY_ID"), 
	inverseJoinColumns=@JoinColumn(name="REGION_ID"))
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

	public List<Region> getRegionList() {
		return RegionList;
	}

	public void setRegionList(List<Region> regionList) {
		RegionList = regionList;
	}
	
	
	
	

}

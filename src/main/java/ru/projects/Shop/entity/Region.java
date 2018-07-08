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
@Table(name="regions")
public class Region {
	@Id @GeneratedValue
	private Long Region_ID;
	private String Region;
	@OneToMany
	@JoinTable(name="region_city", 
	joinColumns=@JoinColumn(name="Region_ID"), 
	inverseJoinColumns=@JoinColumn(name="City_ID"))
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
	
	

}

package ru.projects.Shop.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="adresses")
public class Adress {
	@Id @GeneratedValue
	private Long Adress_ID;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Country_ID", nullable=false)
	private Country Country;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Region_ID")
	private Region Region;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="City_ID")
	private City City;
	private String Street;
	private int NumberOfHouse;
	private String Corpus;
	private int NumberOfEntrance;
	private Long NumberOfAppartament;
	
	public Adress() {}

	public Long getAdress_ID() {
		return Adress_ID;
	}

	public void setAdress_ID(Long adress_ID) {
		Adress_ID = adress_ID;
	}

	public Country getCountry() {
		return Country;
	}

	public void setCountry(Country country) {
		Country = country;
	}

	public Region getRegion() {
		return Region;
	}

	public void setRegion(Region region) {
		Region = region;
	}

	public City getCity() {
		return City;
	}

	public void setCity(City city) {
		City = city;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public int getNumberOfHouse() {
		return NumberOfHouse;
	}

	public void setNumberOfHouse(int numberOfHouse) {
		NumberOfHouse = numberOfHouse;
	}

	public String getCorpus() {
		return Corpus;
	}

	public void setCorpus(String corpus) {
		Corpus = corpus;
	}

	public int getNumberOfEntrance() {
		return NumberOfEntrance;
	}

	public void setNumberOfEntrance(int numberOfEntrance) {
		NumberOfEntrance = numberOfEntrance;
	}

	public Long getNumberOfAppartament() {
		return NumberOfAppartament;
	}

	public void setNumberOfAppartament(Long numberOfAppartament) {
		NumberOfAppartament = numberOfAppartament;
	}
	
	

}

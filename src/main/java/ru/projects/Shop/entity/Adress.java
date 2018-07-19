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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import ru.projects.Shop.constraints.StringConstraint;

@Entity
@XmlRootElement
@Table(name="adresses")
@NamedQuery(name="findAllAdress", query="SELECT a FROM Adress a"
		+ " ORDER BY a.Adress_ID DESC")
public class Adress implements Serializable {
	@Id @GeneratedValue
	private Long Adress_ID;
	@NotNull
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="Country_ID", nullable=false)
	private Country Country;
	@NotNull
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="Region_ID")
	private Region Region;
	@NotNull 
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="City_ID")
	@NotNull
	private City City;
	@NotNull @StringConstraint
	private String Street;
	@NotNull
	private int NumberOfHouse;
	private String Corpus;
	private int NumberOfEntrance;
	@NotNull
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

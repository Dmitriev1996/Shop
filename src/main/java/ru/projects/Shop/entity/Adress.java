package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="adresses")
@NamedQuery(name="findAllAdress", query="SELECT a FROM Adress a"
		+ " ORDER BY a.Adress_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "adress_ID")
public class Adress implements Serializable {
	@Id @GeneratedValue
	@Column(name="ADRESS_ID")
	private Long Adress_ID;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CITY_ID")
	private City City;
	@Column(name="STREET")
	private String Street;
	@Column(name="NUMBER_OF_HOUSE")
	private int NumberOfHouse;
	@Column(name="CORPUS")
	private String Corpus;
	@Column(name="NUMBER_OF_ENTRANCE")
	private int NumberOfEntrance;
	@Column(name="NUMBER_OF_APPARTAMENT")
	private Long NumberOfAppartament;
	
	public Adress() {}

	public Long getAdress_ID() {
		return Adress_ID;
	}

	public void setAdress_ID(Long adress_ID) {
		Adress_ID = adress_ID;
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

package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Country.class)
public class Countries extends ArrayList<Country> {
	public Countries() {
		super();
	}
	
	public Countries(Collection<? extends Country> c) {
		super(c);
	}
	
	@XmlElement(name="country")
	public List<Country> getCountries() {
		return this;
	}
	
	public void setCountriesList(List<Country> countries) {
		this.addAll(countries);
	}

}

package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(City.class)
public class Cities extends ArrayList<City> {
	public Cities() {
		super();
	}
	
	public Cities(Collection<? extends City> c ) {
		super(c);
	}
	
	@XmlElement(name="city")
	public List<City> getCity() {
		return this;
	}
	
	public void setCitiesList(List<City> cities) {
		this.addAll(cities);
	}

}

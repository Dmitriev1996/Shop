package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Adress.class)
public class Adresses extends ArrayList<Adress> {
	public Adresses() {
		super();
	}
	
	public Adresses(Collection<? extends Adress> c ) {
		super(c);
	}
	
	@XmlElement(name="adress")
	public List<Adress> getAdress() {
		return this;
	}
	
	public void setAdressesList(List<Adress> adresses) {
		this.addAll(adresses);
	}

}

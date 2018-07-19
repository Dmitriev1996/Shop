package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Buy.class)
public class Buys extends ArrayList<Buy> {
	public Buys() {
		super();
	}
	
	public Buys(Collection<? extends Buy> c ) {
		super(c);
	}
	
	@XmlElement(name="buy")
	public List<Buy> getBuy() {
		return this;
	}
	
	public void setBuysList(List<Buy> buys) {
		this.addAll(buys);
	}

}

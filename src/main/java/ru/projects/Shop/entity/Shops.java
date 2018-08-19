package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Shop.class)
public class Shops extends ArrayList<Shop> {
	public Shops() {
		super();
	}
	
	public Shops(Collection<? extends Shop> c) {
		super(c);
	}
	
	@XmlElement(name="shops")
	public List<Shop> getShops() {
		return this;
	}
	
	public void setShopList(List<Shop> shops) {
		this.addAll(shops);
	}

}

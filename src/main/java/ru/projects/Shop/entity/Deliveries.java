package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Delivery.class)
public class Deliveries extends ArrayList<Delivery> {
	public Deliveries() {
		super();
	}
	
	public Deliveries(Collection<? extends Delivery> c) {
		super(c);
	}
	
	@XmlElement(name="delivery")
	public List<Delivery> getDeliveries() {
		return this;
	}
	
	public void setDeliveriesList(List<Delivery> deliveries) {
		this.addAll(deliveries);
	}

}

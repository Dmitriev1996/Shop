package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(TransportationType.class)
public class TransportationTypes extends ArrayList<TransportationType> {
	public TransportationTypes() {
		super();
	}
	
	public TransportationTypes(Collection<? extends TransportationType> c) {
		super(c);
	}
	
	@XmlElement(name="transportation_types")
	public List<TransportationType> getTransportationTypes() {
		return this;
	}
	
	public void setTransportationList(List<TransportationType> transportationTypes) {
		this.addAll(transportationTypes);
	}

}

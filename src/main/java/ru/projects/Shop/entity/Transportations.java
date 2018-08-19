package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Transportation.class)
public class Transportations extends ArrayList<Transportation> {
	public Transportations() {
		super();
	}
	
	public Transportations(Collection<? extends Transportation> c) {
		super(c);
	}
	
	@XmlElement(name="transportations")
	public List<Transportation> getTransportations() {
		return this;
	}
	
	public void setTransportationList(List<Transportation> transportations) {
		this.addAll(transportations);
	}
	

}

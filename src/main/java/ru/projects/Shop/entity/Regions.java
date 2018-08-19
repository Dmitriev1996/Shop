package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Region.class)
public class Regions extends ArrayList<Region> {
	public Regions() {
		super();
	}
	
	public Regions(Collection<? extends Region> c) {
		super(c);
	}
	
	@XmlElement(name="regions")
	public List<Region> getRegions() {
		return this;
	}
	
	public void setRegionList(List<Region> regions) {
		this.addAll(regions);
	}

}

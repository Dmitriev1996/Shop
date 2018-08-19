package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Sex.class)
public class Sexes extends ArrayList<Sex> {
	public Sexes() {
		super();
	}
	
	public Sexes(Collection<? extends Sex> c) {
		super(c);
	}
	
	@XmlElement
	public List<Sex> getSexes() {
		return this;
	}
	
	public void setSexList(List<Sex> sexes) {
		this.addAll(sexes);
	}

}

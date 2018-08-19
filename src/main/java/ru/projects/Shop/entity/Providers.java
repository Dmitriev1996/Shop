package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Provider.class)
public class Providers extends ArrayList<Provider> {
	public Providers() {
		super();
	}
	
	public Providers(Collection<? extends Provider> c) {
		super(c);
	}
	
	@XmlElement(name="providers")
	public List<Provider> getProviders() {
		return this;
	}
	
	public void setPrividerList(List<Provider> providers) {
		this.addAll(providers);
	}

}

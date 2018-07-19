package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Client.class)
public class Clients extends ArrayList<Client> {
	public Clients() {
		super();
	}
	
	public Clients(Collection<? extends Client> c ) {
		super(c);
	}
	
	@XmlElement(name="client")
	public List<Client> getClient() {
		return this;
	}
	
	public void setClientList(List<Client> clients) {
		this.addAll(clients);
	}

}

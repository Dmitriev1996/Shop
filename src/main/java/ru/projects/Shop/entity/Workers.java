package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Worker.class)
public class Workers extends ArrayList<Worker> {
	public Workers() {
		super();
	}
	
	public Workers(Collection<? extends Worker> c) {
		super(c);
	}
	
	@XmlElement
	public List<Worker> getWorkers() {
		return this;
	}
	
	public void setWorkerList(List<Worker> workers) {
		this.addAll(workers);
	}

}

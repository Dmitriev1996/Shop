package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Warehouse.class)
public class Warehouses extends ArrayList<Warehouse> {
	public Warehouses() {
		super();
	}
	
	public Warehouses(Collection<? extends Warehouse> c) {
		super(c);
	}
	
	@XmlElement(name="warehouses")
	public List<Warehouse> getWarehouses() {
		return this;
	}
	
	public void setWarehouseList(List<Warehouse> warehouses) {
		this.addAll(warehouses);
	}

}

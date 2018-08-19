package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Order.class)
public class Orders extends ArrayList<Order> {
	public Orders() {
		super();
	}
	
	public Orders(Collection<? extends Order> c) {
		super(c);
	}
	
	@XmlElement(name="order")
	public List<Order> getOrders() {
		return this;
	}
	
	public void setOrderList(List<Order> orders) {
		this.addAll(orders);
	}

}

package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(StatusOfOrder.class)
public class StatusOfOrders extends ArrayList<StatusOfOrder> {
	public StatusOfOrders() {
		super();
	}
	
	public StatusOfOrders(Collection<? extends StatusOfOrder> c) {
		super(c);
	}
	
	@XmlElement(name="status_of_orders")
	public List<StatusOfOrder> getStatusOfOrders() {
		return this;
	}
	
	public void setStatusOfOrderList(List<StatusOfOrder> statusOfOrders) {
		this.addAll(statusOfOrders);
	}

}

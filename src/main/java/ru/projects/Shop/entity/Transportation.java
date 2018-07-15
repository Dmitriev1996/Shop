package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transportations")
@NamedQuery(name="findAllTransportation", query="SELECT t FROM Transportation t"
		+ " ORDER BY t.Transportation_ID DESC")
public class Transportation implements Serializable {
	@Id @GeneratedValue
	private Long Transportation_ID;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Type_ID", nullable=false)
	private TransportationType TransportationType;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Order_ID", nullable=false)
	private Order Order;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Adress_ID", nullable=false)
	private Adress Adress;
	
	public Transportation() {}

	public Long getTransportation_ID() {
		return Transportation_ID;
	}

	public void setTransportation_ID(Long transportation_ID) {
		Transportation_ID = transportation_ID;
	}

	public TransportationType getTransportationType() {
		return TransportationType;
	}

	public void setTransportationType(TransportationType transportationType) {
		TransportationType = transportationType;
	}

	public Adress getAdress() {
		return Adress;
	}

	public void setAdress(Adress adress) {
		Adress = adress;
	}

	public Order getOrder() {
		return Order;
	}

	public void setOrder(Order order) {
		Order = order;
	}
	
	
	
	

}

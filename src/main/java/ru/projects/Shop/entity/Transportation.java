package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="transportations")
@NamedQuery(name="findAllTransportation", query="SELECT t FROM Transportation t"
		+ " ORDER BY t.Transportation_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "transportation_ID")
public class Transportation implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TRANSPORTATION_ID")
	private Long Transportation_ID;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="TRANSPORTATION_TYPE_ID")
	private TransportationType TransportationType;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="ADRESS_ID")
	private Adress Adress;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Transportation")
	@JsonManagedReference("Transportation")
	private Order Order;
	
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

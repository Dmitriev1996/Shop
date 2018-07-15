package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="transportation_type")
@NamedQuery(name="findAllTransportationType", query="SELECT t FROM TransportationType t"
		+ " ORDER BY t.Type_ID DESC")
public class TransportationType implements Serializable {
	@Id @GeneratedValue
	private Long Type_ID;
	private String TransportationType;
	
	public TransportationType() {}

	public Long getType_ID() {
		return Type_ID;
	}

	public void setType_ID(Long type_ID) {
		Type_ID = type_ID;
	}

	public String getTransportationType() {
		return TransportationType;
	}

	public void setTransportationType(String transportationType) {
		TransportationType = transportationType;
	}
	
	

}

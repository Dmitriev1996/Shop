package ru.projects.Shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transportation_type")
public class TransportationType {
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

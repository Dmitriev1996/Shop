package ru.projects.Shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status_of_orders")
public class StatusOfOrder {
	@Id @GeneratedValue
	private Long Status_ID;
	private String Status;
	
	public StatusOfOrder() {}

	public Long getStatus_ID() {
		return Status_ID;
	}

	public void setStatus_ID(Long status_ID) {
		Status_ID = status_ID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	

}

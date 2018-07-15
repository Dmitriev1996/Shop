package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="status_of_orders")
@NamedQuery(name="findAllStatus", query="SELECT s FROM StatusOfOrder s"
		+ " ORDER BY s.Status_ID DESC")
public class StatusOfOrder implements Serializable {
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

package ru.projects.Shop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="status_of_orders")
@NamedQuery(name="findAllStatus", query="SELECT s FROM StatusOfOrder s"
		+ " ORDER BY s.Status_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "status_ID")
public class StatusOfOrder implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STATUS_OF_ORDER_ID")
	private Long Status_ID;
	@Column(name="STATUS")
	private String Status;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="StatusOfOrder")
	@JsonManagedReference("StatusOfOrder")
	private List<Order> OrderList;
	
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

	public List<Order> getOrderList() {
		return OrderList;
	}

	public void setOrderList(List<Order> orderList) {
		OrderList = orderList;
	}
	
	

}

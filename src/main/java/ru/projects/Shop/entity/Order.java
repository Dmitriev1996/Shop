package ru.projects.Shop.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
class Order {
	@Id @GeneratedValue
	private Long Order_ID;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Client_ID", nullable=false)
	private Client Client;
	private Date DateOfBirth;
	@OneToMany
	@JoinTable(name="order_products", 
	joinColumns=@JoinColumn(name="Order_ID"), 
	inverseJoinColumns=@JoinColumn(name="Product_ID"))
	private List<Product> ProductList;
	private Double SumOfOrder;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Transportation_ID", nullable=false)
	private Transportation Transportation;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Status_ID", nullable=false)
	private StatusOfOrder StatusOfOrder;
	
	public Order() {}

	public Long getOrder_ID() {
		return Order_ID;
	}

	public void setOrder_ID(Long order_ID) {
		Order_ID = order_ID;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public List<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(List<Product> productList) {
		ProductList = productList;
	}

	public Double getSumOfOrder() {
		return SumOfOrder;
	}

	public void setSumOfOrder(Double sumOfOrder) {
		SumOfOrder = sumOfOrder;
	}

	public StatusOfOrder getStatusOfOrder() {
		return StatusOfOrder;
	}

	public void setStatusOfOrder(StatusOfOrder statusOfOrder) {
		StatusOfOrder = statusOfOrder;
	}

	public Transportation getTransportation() {
		return Transportation;
	}

	public void setTransportation(Transportation transportation) {
		Transportation = transportation;
	}
	
	
	
	

}

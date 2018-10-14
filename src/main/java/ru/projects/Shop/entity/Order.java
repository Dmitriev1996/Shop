package ru.projects.Shop.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="orders")
@NamedQuery(name="findAllOrder", query="SELECT o FROM Order o"
		+ " ORDER BY o.Order_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "order_ID")
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private Long Order_ID;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CLIENT_ID")
	@JsonBackReference("Client")
	private Client Client;
	@Column(name="DATE_OF_ORDER")
	private Date DateOfOrder;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="order_products", 
	joinColumns=@JoinColumn(name="ORDER_ID"), 
	inverseJoinColumns=@JoinColumn(name="PRODUCT_ID"))
	private List<Product> ProductList;
	@Column(name="SUM_OF_ORDER")
	private Double SumOfOrder;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="TRANSPORTATION_ID")
	@JsonBackReference("Transportation")
	private Transportation Transportation;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="STATUS_OF_ORDER_ID")
	@JsonBackReference("StatusOfOrder")
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

	public Date getDateOfOrder() {
		return DateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		DateOfOrder = dateOfOrder;
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

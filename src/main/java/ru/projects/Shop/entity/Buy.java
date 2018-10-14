package ru.projects.Shop.entity;

import java.io.Serializable;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="buys")
@NamedQuery(name="findAllBuy", query="SELECT b FROM Buy b"
		+ " ORDER BY b.Buy_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "buy_ID")
public class Buy implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BUY_ID")
	private Long Buy_ID;
	@Column(name="DATE_BUY")
	private Date DateBuy;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="buy_products", 
	joinColumns=@JoinColumn(name="BUY_ID"), 
	inverseJoinColumns=@JoinColumn(name="PRODUCT_ID"))
	private List<Product> ProductList;
	@Column(name="SUM_BUY")
	private Double SumBuy;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CLIENT_ID")
	@JsonBackReference("Client")
	private Client Client;
	
	public Buy() {}

	public Long getBuy_ID() {
		return Buy_ID;
	}

	public void setBuy_ID(Long buy_ID) {
		Buy_ID = buy_ID;
	}

	public Date getDateBuy() {
		return DateBuy;
	}

	public void setDateBuy(Date dateBuy) {
		DateBuy = dateBuy;
	}

	public List<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(List<Product> productList) {
		ProductList = productList;
	}

	public Double getSumBuy() {
		return SumBuy;
	}

	public void setSumBuy(Double sumBuy) {
		SumBuy = sumBuy;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}
	
	
	

}

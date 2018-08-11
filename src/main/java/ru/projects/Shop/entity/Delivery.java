package ru.projects.Shop.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="deliveries")
@NamedQuery(name="findAllDelivery", query="SELECT d FROM Delivery d"
		+ " ORDER BY d.Delivery_ID DESC")
public class Delivery implements Serializable {
	@Id @GeneratedValue
	@Column(name="DELIVERY_ID")
	private Long Delivery_ID;
	@Column(name="DATE_OF_DELIVERY")
	private Date DateOfDelivery;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="PROVIDER_ID")
	private Provider Provider;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="SHOP_ID")
	private Shop Shop;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="delivery_products", 
	joinColumns=@JoinColumn(name="DELIVERY_ID"), 
	inverseJoinColumns=@JoinColumn(name="PRODUCT_ID"))
	private List<Product> ProductList;
	
	
	public Delivery() {}

	public Long getDelivery_ID() {
		return Delivery_ID;
	}

	public void setDelivery_ID(Long delivery_ID) {
		Delivery_ID = delivery_ID;
	}

	public Date getDateOfDelivery() {
		return DateOfDelivery;
	}

	public void setDateOfDelivery(Date dateOfDelivery) {
		DateOfDelivery = dateOfDelivery;
	}

	public Provider getProvider() {
		return Provider;
	}

	public void setProvider(Provider provider) {
		Provider = provider;
	}

	public Shop getShop() {
		return Shop;
	}

	public void setShop(Shop shop) {
		Shop = shop;
	}

	public List<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(List<Product> productList) {
		ProductList = productList;
	}
	
	
	

}

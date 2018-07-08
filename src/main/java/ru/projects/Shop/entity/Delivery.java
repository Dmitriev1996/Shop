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
@Table(name="deliveries")
public class Delivery {
	@Id @GeneratedValue
	private Long Delivery_ID;
	private Date DateOfDelivery;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Provider_ID")
	private Provider Provider;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Shop_ID")
	private Shop Shop;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="delivery_products", 
	joinColumns=@JoinColumn(name="Delivery_ID"), 
	inverseJoinColumns=@JoinColumn(name="Product_ID"))
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
	
	

}

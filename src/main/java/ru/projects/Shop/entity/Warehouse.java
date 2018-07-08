package ru.projects.Shop.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="warehouses")
public class Warehouse {
	@Id @GeneratedValue
	private Long Warehouse_ID;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Shop_ID")
	private Shop Shop;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Product_ID")
	private Product Product;
	private Long Value;
	
	public Warehouse() {}

	public Long getWarehouse_ID() {
		return Warehouse_ID;
	}

	public void setWarehouse_ID(Long warehouse_ID) {
		Warehouse_ID = warehouse_ID;
	}

	public Shop getShop() {
		return Shop;
	}

	public void setShop(Shop shop) {
		Shop = shop;
	}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	public Long getValue() {
		return Value;
	}

	public void setValue(Long value) {
		Value = value;
	}
	
	

}

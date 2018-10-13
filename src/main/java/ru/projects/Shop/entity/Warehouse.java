package ru.projects.Shop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="warehouses")
@NamedQuery(name="findAllWarehouse", query="SELECT w FROM Warehouse w"
		+ " ORDER BY w.Warehouse_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "warehouse_ID")
public class Warehouse implements Serializable {
	@Id @GeneratedValue
	@Column(name="WAREHOUSE_ID")
	private Long Warehouse_ID;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Warehouse")
	@JsonManagedReference("Warehouse")
	private Shop Shop;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Warehouse")
	@JsonManagedReference("Warehouse")
	private List<Delivery> DeliveryList;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Warehouse")
	@JsonManagedReference("Warehouse")
	private List<ProductUnit> ProductUnitList;
	
	public Warehouse() {}

	public Long getWarehouse_ID() {
		return Warehouse_ID;
	}

	public void setWarehouse_ID(Long warehouse_ID) {
		Warehouse_ID = warehouse_ID;
	}

	public List<ProductUnit> getProductUnitList() {
		return ProductUnitList;
	}

	public void setProductUnitList(List<ProductUnit> productUnitList) {
		ProductUnitList = productUnitList;
	}

	public Shop getShop() {
		return Shop;
	}

	public void setShop(Shop shop) {
		Shop = shop;
	}

	public List<Delivery> getDeliveryList() {
		return DeliveryList;
	}

	public void setDeliveryList(List<Delivery> deliveryList) {
		DeliveryList = deliveryList;
	}
	
	

	
	

}

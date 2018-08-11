package ru.projects.Shop.entity;

import java.io.Serializable;
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
@Table(name="warehouses")
@NamedQuery(name="findAllWarehouse", query="SELECT w FROM Warehouse w"
		+ " ORDER BY w.Warehouse_ID DESC")
public class Warehouse implements Serializable {
	@Id @GeneratedValue
	@Column(name="WAREHOUSE_ID")
	private Long Warehouse_ID;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="SHOP_ID")
	private Shop Shop;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="warehouse_products", 
	joinColumns=@JoinColumn(name="WAREHOUSE_ID"), 
	inverseJoinColumns=@JoinColumn(name="PRODUCT_UNIT_ID"))
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
	
	

	
	

}

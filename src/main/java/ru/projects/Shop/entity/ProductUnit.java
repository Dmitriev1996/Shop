package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="product_unit")
@NamedQuery(name="findAllProductUnit", query="SELECT u FROM ProductUnit u"
		+ " ORDER BY u.ProductUnit_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "productUnit_ID")
public class ProductUnit implements Serializable {
	@Id @GeneratedValue
	@Column(name="PRODUCT_UNIT_ID")
	private Long ProductUnit_ID;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="WAREHOUSE_ID")
	@JsonBackReference
	private Warehouse Warehouse;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_ID")
	private Product Product;
	@Column(name="VALUE")
	private int Value;
	
	public ProductUnit() {}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	public int getValue() {
		return Value;
	}

	public void setValue(int value) {
		Value = value;
	}

	public Long getProductUnit_ID() {
		return ProductUnit_ID;
	}

	public void setProductUnit_ID(Long productUnit_ID) {
		ProductUnit_ID = productUnit_ID;
	}

	public Warehouse getWarehouse() {
		return Warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		Warehouse = warehouse;
	}
	
	

}

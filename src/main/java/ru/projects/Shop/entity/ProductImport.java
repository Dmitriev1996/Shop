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
@Table(name="product_imports")
@NamedQuery(name="findAllProductImport", query="SELECT i FROM ProductImport i"
		+ " ORDER BY i.ProductImport_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "productImport_ID")
public class ProductImport implements Serializable {
	@Id @GeneratedValue
	@Column(name="PRODUCT_IMPORT_ID")
	private Long ProductImport_ID;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_ID")
	private Product Product;
	@Column(name="VALUE")
	private int Value;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="DELIVERY_ID")
	@JsonBackReference("Delivery")
	private Delivery Delivery;
	
	public ProductImport() {}

	public Long getProductImport_ID() {
		return ProductImport_ID;
	}

	public void setProductImport_ID(Long productImport_ID) {
		ProductImport_ID = productImport_ID;
	}

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

	public Delivery getDelivery() {
		return Delivery;
	}

	public void setDelivery(Delivery delivery) {
		Delivery = delivery;
	}
	
	
	

}

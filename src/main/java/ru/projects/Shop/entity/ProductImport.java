package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_imports")
@NamedQuery(name="findAllProductImport", query="SELECT i FROM ProductImport i"
		+ " ORDER BY i.ProductImport_ID DESC")
public class ProductImport implements Serializable {
	@Id @GeneratedValue
	@Column(name="PRODUCT_IMPORT_ID")
	private Long ProductImport_ID;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_ID")
	private Product Product;
	@Column(name="VALUE")
	private int Value;
	
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
	
	
	

}

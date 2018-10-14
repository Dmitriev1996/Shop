package ru.projects.Shop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="type_products")
@NamedQuery(name="findAllTypeProduct", query="SELECT t FROM TypeProduct t"
		+ " ORDER BY t.TypeProduct_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "typeProduct_ID")
public class TypeProduct implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TYPE_PRODUCT_ID")
	private Long TypeProduct_ID;
	@Column(name="TYPE_PRODUCT")
	private String TypeProduct;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="TypeProduct")
	@JsonManagedReference("TypeProduct")
	private List<Product> ProductList;
	
	public TypeProduct() {}

	public Long getTypeProduct_ID() {
		return TypeProduct_ID;
	}

	public void setTypeProduct_ID(Long typeProduct_ID) {
		TypeProduct_ID = typeProduct_ID;
	}

	public String getTypeProduct() {
		return TypeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		TypeProduct = typeProduct;
	}

	public List<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(List<Product> productList) {
		ProductList = productList;
	}
	
	

}

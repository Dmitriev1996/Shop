package ru.projects.Shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="type_products")
public class TypeProduct {
	@Id @GeneratedValue
	private Long TypeProduct_ID;
	private String TypeProduct;
	
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
	
	

}

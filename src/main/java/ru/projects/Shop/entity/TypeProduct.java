package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="type_products")
@NamedQuery(name="findAllTypeProduct", query="SELECT t FROM TypeProduct t"
		+ " ORDER BY t.TypeProduct_ID DESC")
public class TypeProduct implements Serializable {
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

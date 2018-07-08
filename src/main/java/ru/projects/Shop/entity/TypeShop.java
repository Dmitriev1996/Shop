package ru.projects.Shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="type_shops")
public class TypeShop {
	@Id @GeneratedValue
	private Long TypeShop_ID;
	private String TypeShop;
	
	public TypeShop() {}

	public Long getTypeShop_ID() {
		return TypeShop_ID;
	}

	public void setTypeShop_ID(Long typeShop_ID) {
		TypeShop_ID = typeShop_ID;
	}

	public String getTypeShop() {
		return TypeShop;
	}

	public void setTypeShop(String typeShop) {
		TypeShop = typeShop;
	}
	
	

}

package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="type_shops")
@NamedQuery(name="findAllTypeShop", query="SELECT t FROM TypeShop t"
		+ " ORDER BY t.TypeShop_ID DESC")
public class TypeShop implements Serializable {
	@Id @GeneratedValue
	@Column(name="TYPE_SHOP_ID")
	private Long TypeShop_ID;
	@Column(name="TYPE_SHOP")
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

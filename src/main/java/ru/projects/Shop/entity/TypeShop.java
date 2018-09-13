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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="type_shops")
@NamedQuery(name="findAllTypeShop", query="SELECT t FROM TypeShop t"
		+ " ORDER BY t.TypeShop_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "typeShop_ID")
public class TypeShop implements Serializable {
	@Id @GeneratedValue
	@Column(name="TYPE_SHOP_ID")
	private Long TypeShop_ID;
	@Column(name="TYPE_SHOP")
	private String TypeShop;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="TypeShop")
	@JsonManagedReference
	private List<Shop> ShopList;
	
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

	public List<Shop> getShopList() {
		return ShopList;
	}

	public void setShopList(List<Shop> shopList) {
		ShopList = shopList;
	}
	
	
	

}

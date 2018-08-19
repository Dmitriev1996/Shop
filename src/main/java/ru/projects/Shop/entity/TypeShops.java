package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(TypeShop.class)
public class TypeShops extends ArrayList<TypeShop> {
	public TypeShops() {
		super();
	}
	
	public TypeShops(Collection<? extends TypeShop> c) {
		super(c);
	}
	
	@XmlElement(name="type_shop")
	public List<TypeShop> getTypeShops() {
		return this;
	}
	
	
	public void setTypeShopList(List<TypeShop> typeShopList) {
		this.addAll(typeShopList);
	}

}

package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(TypeProduct.class)
public class TypeProducts extends ArrayList<TypeProduct> {
	public TypeProducts() {
		super();
	}
	
	public TypeProducts(Collection<? extends TypeProduct> c) {
		super(c);
	}
	
	@XmlElement(name="type_product")
	public List<TypeProduct> getTypeProducts() {
		return this;
	}
	
	public void setTypeProductList(List<TypeProduct> typeProducts) {
		this.addAll(typeProducts);
	}

}

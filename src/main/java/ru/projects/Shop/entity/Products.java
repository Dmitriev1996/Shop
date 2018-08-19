package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Product.class)
public class Products extends ArrayList<Product> {
	public Products() {
		super();
	}
	
	public Products(Collection<? extends Product> c) {
		super(c);
	}
	
	@XmlElement(name="product")
	public List<Product> getProducts() {
		return this;
	}
	
	public void setProductList(List<Product> products) {
		this.addAll(products);
	}

}

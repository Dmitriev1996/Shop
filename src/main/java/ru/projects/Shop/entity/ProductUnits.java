package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(ProductUnit.class)
public class ProductUnits extends ArrayList<ProductUnit> {
	public ProductUnits() {
		super();
	}
	
	public ProductUnits(Collection<? extends ProductUnit> c) {
		super(c);
	}
	
	@XmlElement(name="product_unit")
	public List<ProductUnit> getProductUnits() {
		return this;
	}
	
	public void setProductUnitList(List<ProductUnit> productUnits) {
		this.addAll(productUnits);
	}

}

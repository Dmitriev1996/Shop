package ru.projects.Shop.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="buys")
public class Buy {
	@Id @GeneratedValue
	private Long Buy_ID;
	private Date DateBuy;
	@OneToMany
	@JoinTable(name="buy_products", 
	joinColumns=@JoinColumn(name="Buy_ID"), 
	inverseJoinColumns=@JoinColumn(name="Product_ID"))
	private List<Product> ProductList;
	private Double SumBuy;
	
	public Buy() {}

	public Long getBuy_ID() {
		return Buy_ID;
	}

	public void setBuy_ID(Long buy_ID) {
		Buy_ID = buy_ID;
	}

	public Date getDateBuy() {
		return DateBuy;
	}

	public void setDateBuy(Date dateBuy) {
		DateBuy = dateBuy;
	}

	public List<Product> getProductList() {
		return ProductList;
	}

	public void setProductList(List<Product> productList) {
		ProductList = productList;
	}

	public Double getSumBuy() {
		return SumBuy;
	}

	public void setSumBuy(Double sumBuy) {
		SumBuy = sumBuy;
	}
	
	

}

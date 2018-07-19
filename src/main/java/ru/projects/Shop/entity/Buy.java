package ru.projects.Shop.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="buys")
@NamedQuery(name="findAllBuy", query="SELECT b FROM Buy b"
		+ " ORDER BY b.Buy_ID DESC")
public class Buy implements Serializable {
	@Id @GeneratedValue
	private Long Buy_ID;
	private Date DateBuy;
	@OneToMany(cascade=CascadeType.ALL)
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

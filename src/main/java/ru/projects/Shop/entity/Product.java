package ru.projects.Shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id @GeneratedValue
	private Long Product_ID;
	private String NameOfProduct;
	private String Articul;
	private Double Price;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TypeProduct_ID", nullable=false)
	private TypeProduct TypeProduct;
	private Double Mass;
	private String Description;
	@OneToMany
	@JoinTable(name="product_comments", 
	joinColumns=@JoinColumn(name="Product_ID"), 
	inverseJoinColumns=@JoinColumn(name="Comment_ID"))
	private List<Comment> CommentList;
	
	public Product() {}

	public Long getProduct_ID() {
		return Product_ID;
	}

	public void setProduct_ID(Long product_ID) {
		Product_ID = product_ID;
	}

	public String getNameOfProduct() {
		return NameOfProduct;
	}

	public void setNameOfProduct(String nameOfProduct) {
		NameOfProduct = nameOfProduct;
	}

	public String getArticul() {
		return Articul;
	}

	public void setArticul(String articul) {
		Articul = articul;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public TypeProduct getTypeProduct() {
		return TypeProduct;
	}

	public void setTypeProduct(TypeProduct typeProduct) {
		TypeProduct = typeProduct;
	}

	public Double getMass() {
		return Mass;
	}

	public void setMass(Double mass) {
		Mass = mass;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Comment> getCommentList() {
		return CommentList;
	}

	public void setCommentList(List<Comment> commentList) {
		CommentList = commentList;
	}
	
	
	
	

}

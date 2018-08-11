package ru.projects.Shop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
@NamedQuery(name="findAllProduct", query="SELECT p FROM Product p"
		+ " ORDER BY p.Product_ID DESC")
public class Product implements Serializable {
	@Id @GeneratedValue
	@Column(name="PRODUCT_ID")
	private Long Product_ID;
	@Column(name="NAME_OF_PRODUCT")
	private String NameOfProduct;
	@Column(name="ARTICUL")
	private String Articul;
	@Column(name="PRICE")
	private Double Price;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="TYPE_PRODUCT_ID", nullable=false)
	private TypeProduct TypeProduct;
	@Column(name="MASS")
	private Double Mass;
	@Column(name="DESCRIPTION")
	private String Description;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="product_comments", 
	joinColumns=@JoinColumn(name="PRODUCT_ID"), 
	inverseJoinColumns=@JoinColumn(name="COMMENT_ID"))
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

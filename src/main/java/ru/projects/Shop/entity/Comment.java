package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="comments")
@NamedQuery(name="findAllComment", query="SELECT c FROM Comment c"
		+ " ORDER BY c.Comment_ID DESC")
public class Comment implements Serializable {
	@Id @GeneratedValue
	private Long Comment_ID;
	private String Comment;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="client_comments", 
	joinColumns=@JoinColumn(name="Comment_ID"), 
	inverseJoinColumns=@JoinColumn(name="Client_ID"))
	private Client Client;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name="product_comments", 
	joinColumns=@JoinColumn(name="Comment_ID"), 
	inverseJoinColumns=@JoinColumn(name="Product_ID"))
	private Product Product;
	
	public Comment() {}

	public Long getComment_ID() {
		return Comment_ID;
	}

	public void setComment_ID(Long comment_ID) {
		Comment_ID = comment_ID;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}
	
	
	
	

}

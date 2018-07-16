package ru.projects.Shop.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="clients")
@NamedQuery(name="findAllClient", query="SELECT c FROM Client c"
		+ " ORDER BY c.Client_ID DESC")
public class Client implements Serializable {
	@Id @GeneratedValue
	private Long Client_ID;
	private String Surname;
	private String Name;
	private String Patronymic;
	private Date DateOfBirth;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="Sex_ID", nullable=false)
	private Sex Sex;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="client_buys", 
	joinColumns=@JoinColumn(name="Client_ID"), 
	inverseJoinColumns=@JoinColumn(name="Buy_ID"))
	private List<Buy> BuyList;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="client_order", 
	joinColumns=@JoinColumn(name="Client_ID"), 
	inverseJoinColumns=@JoinColumn(name="Order_ID"))
	private List<Order> OrderList;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="client_comments", 
	joinColumns=@JoinColumn(name="Client_ID"), 
	inverseJoinColumns=@JoinColumn(name="Comment_ID"))
	private List<Comment> CommentList;
	
	public Client() {}

	public Long getClient_ID() {
		return Client_ID;
	}

	public void setClient_ID(Long client_ID) {
		Client_ID = client_ID;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPatronymic() {
		return Patronymic;
	}

	public void setPatronymic(String patronymic) {
		Patronymic = patronymic;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public Sex getSex() {
		return Sex;
	}

	public void setSex(Sex sex) {
		Sex = sex;
	}

	public List<Buy> getBuyList() {
		return BuyList;
	}

	public void setBuyList(List<Buy> buyList) {
		BuyList = buyList;
	}

	public List<Order> getOrderList() {
		return OrderList;
	}

	public void setOrderList(List<Order> orderList) {
		OrderList = orderList;
	}
	
	
	
	

}

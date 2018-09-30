package ru.projects.Shop.entity;

import java.io.Serializable;
import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="clients")
@NamedQuery(name="findAllClient", query="SELECT c FROM Client c"
		+ " ORDER BY c.Client_ID DESC")

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "client_ID")
public class Client implements Serializable {
	@Id @GeneratedValue
	@Column(name="CLIENT_ID")
	private Long Client_ID;
	@Column(name="SURNAME")
	private String Surname;
	@Column(name="NAME")
	private String Name;
	@Column(name="PATRONYMIC")
	private String Patronymic;
	@Column(name="DATE_OF_BIRTH")
	private Date DateOfBirth;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="SEX_ID", nullable=false)
	private Sex Sex;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Client")
	@JsonManagedReference
	private BonusCard BonusCard;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Client")
	@JsonManagedReference
	private List<Buy> BuyList;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Client")
	@JsonManagedReference
	private List<Order> OrderList;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Client")
	@JsonManagedReference
	private List<Comment> CommentList;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Client")
	@JsonManagedReference
	private List<Forum> ForumList;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="Client")
	@JsonManagedReference
	private List<Message> MessageList;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CREDENTIAL_ID")
	private Credential Credential;
	
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

	public List<Comment> getCommentList() {
		return CommentList;
	}

	public void setCommentList(List<Comment> commentList) {
		CommentList = commentList;
	}

	public BonusCard getBonusCard() {
		return BonusCard;
	}

	public void setBonusCard(BonusCard bonusCard) {
		BonusCard = bonusCard;
	}

	public List<Forum> getForumList() {
		return ForumList;
	}

	public void setForumList(List<Forum> forumList) {
		ForumList = forumList;
	}

	public List<Message> getMessageList() {
		return MessageList;
	}

	public void setMessageList(List<Message> messageList) {
		MessageList = messageList;
	}

	public Credential getCredential() {
		return Credential;
	}

	public void setCredential(Credential credential) {
		Credential = credential;
	}
	
	
	
	

}

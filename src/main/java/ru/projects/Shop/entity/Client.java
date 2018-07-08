package ru.projects.Shop.entity;

import java.sql.Date;
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
@Table(name="clients")
public class Client {
	@Id @GeneratedValue
	private Long Client_ID;
	private String Surname;
	private String Name;
	private String Patronymic;
	private Date DateOfBirth;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Sex_ID", nullable=false)
	private Sex Sex;
	@OneToMany
	@JoinTable(name="client_buys", 
	joinColumns=@JoinColumn(name="Client_ID"), 
	inverseJoinColumns=@JoinColumn(name="Buy_ID"))
	private List<Buy> BuyList;
	
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
	
	

}

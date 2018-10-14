package ru.projects.Shop.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="workers")
@NamedQuery(name="findAllWorker", query="SELECT w FROM Worker w"
		+ " ORDER BY w.Worker_ID DESC")
public class Worker implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="WORKER_ID")
	private Long Worker_ID;
	@Column(name="SURNAME")
	private String Surname;
	@Column(name="NAME")
	private String Name;
	@Column(name="PATRONYMIC")
	private String Patronymic;
	@Column(name="DATE_OF_BIRTH")
	private Date DateOfBirth;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="SEX_ID")
	private Sex Sex;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="ADRESS_ID")
	private Adress Adress;
	
	public Worker() {}

	public Long getWorker_ID() {
		return Worker_ID;
	}

	public void setWorker_ID(Long worker_ID) {
		Worker_ID = worker_ID;
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

	public Adress getAdress() {
		return Adress;
	}

	public void setAdress(Adress adress) {
		Adress = adress;
	}
	
	

}

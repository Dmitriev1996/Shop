package ru.projects.Shop.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
	@Id @GeneratedValue
	private Long Worker_ID;
	private String Surname;
	private String Name;
	private String Patronymic;
	private Date DateOfBirth;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Sex_ID", nullable=false)
	private Sex Sex;
	
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
	
	

}

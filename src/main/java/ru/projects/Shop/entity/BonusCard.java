package ru.projects.Shop.entity;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="bonus_cards")
@NamedQuery(name="findAllBonusCard", query="SELECT c FROM BonusCard c"
		+ " ORDER BY c.Card_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "card_ID")
public class BonusCard implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BONUS_CARD_ID")
	private Long Card_ID;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CLIENT_ID")
	@JsonBackReference("Client")
	private Client Client;
	@Column(name="SUM_OF_BONUS")
	private double SumOfBonus;
	
	public BonusCard() {}

	public Long getCard_ID() {
		return Card_ID;
	}

	public void setCard_ID(Long card_ID) {
		Card_ID = card_ID;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	public double getSumOfBonus() {
		return SumOfBonus;
	}

	public void setSumOfBonus(double sumOfBonus) {
		SumOfBonus = sumOfBonus;
	}
	
	
	
	

}

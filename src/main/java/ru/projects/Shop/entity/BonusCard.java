package ru.projects.Shop.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bonus_cards")
public class BonusCard {
	@Id @GeneratedValue
	private Long Card_ID;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Client_ID", nullable=false)
	private Client Client;
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

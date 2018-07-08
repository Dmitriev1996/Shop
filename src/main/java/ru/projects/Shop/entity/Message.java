package ru.projects.Shop.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Message {
	@Id @GeneratedValue
	private Long Message_ID;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Client_ID", nullable=false)
	private Client Client_ID;
	private Date DateOfMessage;
	
	public Message() {}

	public Long getMessage_ID() {
		return Message_ID;
	}

	public void setMessage_ID(Long message_ID) {
		Message_ID = message_ID;
	}

	public Client getClient_ID() {
		return Client_ID;
	}

	public void setClient_ID(Client client_ID) {
		Client_ID = client_ID;
	}

	public Date getDateOfMessage() {
		return DateOfMessage;
	}

	public void setDateOfMessage(Date dateOfMessage) {
		DateOfMessage = dateOfMessage;
	}
	
	

}

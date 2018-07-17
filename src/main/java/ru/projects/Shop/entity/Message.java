package ru.projects.Shop.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="messages")
@NamedQuery(name="findAllMessage", query="SELECT m FROM Message m"
		+ " ORDER BY m.Message_ID DESC")
public class Message implements Serializable {
	@Id @GeneratedValue
	private Long Message_ID;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="Client_ID", nullable=false)
	private Client Client;
	private Date DateOfMessage;
	private String Message;
	
	public Message() {}

	public Long getMessage_ID() {
		return Message_ID;
	}

	public void setMessage_ID(Long message_ID) {
		Message_ID = message_ID;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	public Date getDateOfMessage() {
		return DateOfMessage;
	}

	public void setDateOfMessage(Date dateOfMessage) {
		DateOfMessage = dateOfMessage;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	

}

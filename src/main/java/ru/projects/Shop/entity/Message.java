package ru.projects.Shop.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="messages")
@NamedQuery(name="findAllMessage", query="SELECT m FROM Message m"
		+ " ORDER BY m.Message_ID DESC")
public class Message implements Serializable {
	@Id @GeneratedValue
	@Column(name="MESSAGE_ID")
	private Long Message_ID;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="client_messages", 
	joinColumns=@JoinColumn(name="MESSAGE_ID"), 
	inverseJoinColumns=@JoinColumn(name="CLIENT_ID"))
	private Client Client;
	@Column(name="DATE_OF_MESSAGE")
	private Date DateOfMessage;
	@Column(name="MESSAGE")
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

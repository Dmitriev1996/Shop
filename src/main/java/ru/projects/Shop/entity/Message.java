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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="messages")
@NamedQuery(name="findAllMessage", query="SELECT m FROM Message m"
		+ " ORDER BY m.Message_ID DESC")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "message_ID")
public class Message implements Serializable {
	@Id @GeneratedValue
	@Column(name="MESSAGE_ID")
	private Long Message_ID;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CLIENT_ID")
	@JsonBackReference("Client")
	private Client Client;
	@Column(name="DATE_OF_MESSAGE")
	private Date DateOfMessage;
	@Column(name="MESSAGE")
	private String Message;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="FORUM_ID")
	@JsonBackReference("Forum")
	private Forum Forum;
	
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

	public Forum getForum() {
		return Forum;
	}

	public void setForum(Forum forum) {
		Forum = forum;
	}
	
	

}

package ru.projects.Shop.entity;

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
@Table(name="forums")
public class Forum {
	@Id @GeneratedValue
	private Long Forum_ID;
	private String NameOfForum;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Client_ID", nullable=false)
	private Client Client;
	@OneToMany
	@JoinTable(name="forum_messages", 
	joinColumns=@JoinColumn(name="Forum_ID"), 
	inverseJoinColumns=@JoinColumn(name="Message_ID"))
	private List<Message> MessageList;
	
	public Forum() {}

	public Long getForum_ID() {
		return Forum_ID;
	}

	public void setForum_ID(Long forum_ID) {
		Forum_ID = forum_ID;
	}

	public String getNameOfForum() {
		return NameOfForum;
	}

	public void setNameOfForum(String nameOfForum) {
		NameOfForum = nameOfForum;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	public List<Message> getMessageList() {
		return MessageList;
	}

	public void setMessageList(List<Message> messageList) {
		MessageList = messageList;
	}
	
	

}

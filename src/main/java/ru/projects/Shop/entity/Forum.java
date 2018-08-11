package ru.projects.Shop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="forums")
@NamedQuery(name="findAllForum", query="SELECT f FROM Forum f"
		+ " ORDER BY f.Forum_ID DESC")
public class Forum implements Serializable {
	@Id @GeneratedValue
	@Column(name="FORUM_ID")
	private Long Forum_ID;
	@Column(name="NAME_OF_FORUM")
	private String NameOfForum;
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CLIENT_ID", nullable=false)
	private Client Client;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="forum_messages", 
	joinColumns=@JoinColumn(name="FORUM_ID"), 
	inverseJoinColumns=@JoinColumn(name="MESSAGE_ID"))
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

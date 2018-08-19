package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Message.class)
public class Messages extends ArrayList<Message> {
	public Messages() {
		super();
	}
	
	public Messages(Collection<? extends Message> c) {
		super(c);
	}
	
	@XmlElement(name="message")
	public List<Message> getMessages() {
		return this;
	}
	
	public void setMessagesList(List<Message> messages) {
		this.addAll(messages);
	}

}

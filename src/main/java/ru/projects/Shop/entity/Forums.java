package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Forum.class)
public class Forums extends ArrayList<Forum> {
	public Forums() {
		super();
	}
	
	public Forums(Collection<? extends Forum> c) {
		super(c);
	}
	
	@XmlElement(name="forum")
	public List<Forum> getForums() {
		return this;
	}
	
	public void setForumsList(List<Forum> forums) {
		this.addAll(forums);
	}

}

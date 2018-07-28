package ru.projects.Shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(Comment.class)
public class Comments extends ArrayList<Comment> {
	public Comments() {
		super();
	}
	
	public Comments(Collection<? extends Comment> c ) {
		super(c);
	}
	
	@XmlElement(name="comment")
	public List<Comment> getComments() {
		return this;
	}
	
	public void setCommentsList(List<Comment> comments) {
		this.addAll(comments);
	}


}

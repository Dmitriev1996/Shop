package ru.projects.Shop.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="comments")
@NamedQuery(name="findAllComment", query="SELECT c FROM Comment c"
		+ " ORDER BY c.Comment_ID DESC")
public class Comment implements Serializable {
	@Id @GeneratedValue
	private Long Comment_ID;
	private String Comment;
	
	public Comment() {}

	public Long getComment_ID() {
		return Comment_ID;
	}

	public void setComment_ID(Long comment_ID) {
		Comment_ID = comment_ID;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}
	
	

}

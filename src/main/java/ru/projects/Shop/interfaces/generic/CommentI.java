package ru.projects.Shop.interfaces.generic;

import java.util.List;

import javax.ejb.Local;

import ru.projects.Shop.entity.Comment;

public interface CommentI {
	List<Comment> findAllComment();
	Comment findCommentById(Long id);
	Comment createComment(Comment comment);
	Comment updateComment(Comment comment);
	Comment deleteComment(Long id);

}

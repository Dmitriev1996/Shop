package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Comment;
import ru.projects.Shop.interfaces.local.CommentLocal;

@Stateless
@Local(CommentLocal.class)
@LocalBean
public class CommentEJB implements CommentLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Comment> findAllComment() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllComment", Comment.class).getResultList();
	}

	@Override
	public Comment findCommentById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Comment.class, id);
	}

	@Override
	public Comment createComment(Comment comment) {
		// TODO Auto-generated method stub
		em.persist(comment);
		return comment;
	}

	@Override
	public Comment updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return em.merge(comment);
	}

	@Override
	public void deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		em.remove(em.merge(comment));
	}

}

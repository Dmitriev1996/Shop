package ru.projects.Shop.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ru.projects.Shop.entity.Forum;
import ru.projects.Shop.interfaces.local.ForumLocal;

@Stateless
@Local(ForumLocal.class)
@LocalBean
public class ForumEJB implements ForumLocal {
	@Inject
	private EntityManager em;

	@Override
	public List<Forum> findAllForum() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("findAllForum", Forum.class).getResultList();
	}

	@Override
	public Forum findForumById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Forum.class, id);
	}

	@Override
	public Forum createForum(Forum forum) {
		// TODO Auto-generated method stub
		em.persist(forum);
		return forum;
	}

	@Override
	public Forum updateForum(Forum forum) {
		// TODO Auto-generated method stub
		return em.merge(forum);
	}

	@Override
	public void deleteForum(Forum forum) {
		// TODO Auto-generated method stub
		em.remove(em.merge(forum));
	}

}
